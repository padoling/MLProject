package com.ja.mlproject.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ja.mlproject.service.LearningService;
import com.ja.mlproject.util.ReadCsv;
import com.ja.mlproject.vo.CsvVO;
import com.ja.mlproject.vo.DataFileVO;
import com.ja.mlproject.vo.ProjectVO;
import com.ja.mlproject.vo.SessionVO;

@Controller
public class LearningController {
	
	@Autowired
	private LearningService learningService;
	
	// 새 프로젝트 생성 및 기존 프로젝트 선택 페이지
	@RequestMapping("/programUsingPage")
	public String programUsingPage(HttpSession session, Model model) {
		SessionVO sessionVO = (SessionVO)session.getAttribute("sessionData");
		
		ArrayList<ProjectVO> projectList = learningService.getMyProjectList(sessionVO.getSessionIdx());
		model.addAttribute("projectList", projectList);
		
		return "programUsingPage";
	}
	
	@RequestMapping("/createProjectAction")
	public String createProjectAction(ProjectVO requestParam, RedirectAttributes redirectAttributes) {
		ProjectVO createdProject = learningService.createProject(requestParam);
		
		redirectAttributes.addAttribute("m_idx", createdProject.getM_idx());
		redirectAttributes.addAttribute("p_idx", createdProject.getP_idx());
		
		return "redirect:csvUploadPage";
	}
	
	// csv파일 선택해서 적용하는 페이지
	@RequestMapping("/csvUploadPage")
	public String csvUploadPage(ProjectVO requestParam, Model model) {
		model.addAttribute("m_idx", requestParam.getM_idx());
		model.addAttribute("p_idx", requestParam.getP_idx());
		
		return "csvUploadPage";
	}
	
	// 실제 프로젝트 페이지
	@RequestMapping("/projectPage")
	public String projectPage(HttpServletRequest request, Model model) {
		ProjectVO projectVO = new ProjectVO();
		System.out.println("m_idx : " + request.getParameter("m_idx"));
		System.out.println("p_idx : " + request.getParameter("p_idx"));
		System.out.println("d_idx : " + request.getParameter("d_idx"));
		System.out.println("index : " + request.getParameter("index"));
		
		projectVO.setM_idx((String)request.getParameter("m_idx"));
		projectVO.setP_idx((String)request.getParameter("p_idx"));
		
		ProjectVO selectedProject = learningService.getSelectedProject(projectVO);
		model.addAttribute("selectedProject", selectedProject);
		model.addAttribute("d_idx", request.getParameter("d_idx"));
		model.addAttribute("list", request.getParameter("index"));
		
		return "projectPage";
	}
	
	@ResponseBody
	@RequestMapping("/fileUploadAction")
	public CsvVO fileUploadAction(MultipartFile file, HttpSession session) {
		String sp = File.separator;
		
		// 폴더 경로 설정
		String uploadRootFolderName = "C:"+sp+"dev_tools"+sp+"temp"+sp;
		String oriFilename = file.getOriginalFilename();
		String randomFilename = UUID.randomUUID().toString();	// 랜덤 값 생성
		randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.'));	// 확장자 붙이기
		
		String filepath = uploadRootFolderName + randomFilename;
		System.out.println(filepath);
		
		// 파일 저장
		try {
			file.transferTo(new File(filepath));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// m_idx 구하기
		SessionVO sessionVO = (SessionVO)session.getAttribute("sessionData");
		String m_idx = sessionVO.getSessionIdx();
		
		// db에 저장
		DataFileVO dataFileVO = new DataFileVO(null, m_idx, oriFilename, filepath);
		DataFileVO selectedFile = learningService.insertDataFile(dataFileVO);
		
		// csv파일에서 index 불러오기
		ArrayList<String> index = new ReadCsv().readIndex(filepath);
		System.out.println("d_idx" + selectedFile.getD_idx());
		
		CsvVO csvVO = new CsvVO(selectedFile.getD_idx(), index);
		
		return csvVO;
	}
	
	
	
	// 특정 url로 json 보내는 메소드
	@ResponseBody
	@RequestMapping("/outputJson")
	public Map<Object, Object> outputJson(@RequestBody String requestJson) {
		System.out.println("outputJson 시작");
		System.out.println("ajax로 넘어온 json : " + requestJson);
		
	    String resultImg = null;
	    
	    // json으로 parsing한 뒤 filepath 변경
	    String json = "";
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(requestJson);
			// 기존 json에는 실제 filepath 대신 d_idx가 저장되어 있음
			String d_idx = (String)jsonObject.get("filepath");
			
			// db에서 d_idx로 filepath 불러오기
			DataFileVO dataFileVO = learningService.getFilePath(d_idx);
			String filepath = dataFileVO.getD_filelink();
			
			jsonObject.replace("filepath", filepath);
			
			json = jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			URL url = new URL("http://localhost/mlproject/outputResult");	// url 설정
			
			// connection 열기...
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		
			httpCon.setDoOutput(true);	// 값을 보내기 위해 true로 설정
			httpCon.setRequestMethod("POST");	// POST방식
			httpCon.setRequestProperty("Content-Type", "application/json");	// request 값의 타입 설정
			httpCon.setRequestProperty("Accept", "text/html");		// 받을 response 값의 타입 설정
			httpCon.setConnectTimeout(10000); // 서버에 연결되는 Timeout 시간 설정
			httpCon.setReadTimeout(10000);
			
			// OutputStream으로 request 보내기
			OutputStream os = httpCon.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.flush();
			
			// InputStream으로 response 받기
			BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"));
			resultImg = in.readLine();
			System.out.println(resultImg);
			
			// 연결 해제
			httpCon.disconnect();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("resultImg", resultImg);
		System.out.println("outputJson 끝");
		return map;
	}
	
	// json 받고 response 돌려주는 쪽 메소드
	@RequestMapping("/outputResult")
	public String outputResult(@RequestBody Map<String, String> json, HttpServletResponse response) {
		System.out.println("outputResult 시작");
		String result = json.toString();
		System.out.println(result);
		
		String filepath = "./resultImg/catjo.jpg";
		try {
			response.getWriter().print(filepath);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("outputResult 끝");
		return null;
	}
	
}
