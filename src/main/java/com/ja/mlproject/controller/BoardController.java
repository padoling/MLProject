package com.ja.mlproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ja.mlproject.service.BoardService;
import com.ja.mlproject.service.CommentService;
import com.ja.mlproject.vo.BoardMemberVO;
import com.ja.mlproject.vo.BoardVO;
import com.ja.mlproject.vo.CommentBoardVO;
import com.ja.mlproject.vo.PagingVO;
import com.ja.mlproject.vo.PagingVO2;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;

	@RequestMapping("/testBoardPage")
	public String testBoardPage(PagingVO vo,Model model) {
		ArrayList<BoardMemberVO> testlist = boardService.getBoardListWithPaging(vo);
		model.addAttribute("boardDataList", testlist);
			
		PagingVO2 pagingVO2 = new PagingVO2();
		pagingVO2.setPagingVO(vo);
		
		if(vo.getSearchTarget() == null) {
			pagingVO2.setTotalCount(boardService.boardListCount());
			System.out.println("검색XXXX : " + pagingVO2.getTotalCount());
			
		}else if(vo.getSearchTarget().equals("m_nickname")) {

		}else {
			pagingVO2.setTotalCount(boardService.countSearchWord(vo));
			System.out.println("검색 할때 카운 트 : " + pagingVO2.getTotalCount());
		}
		
		model.addAttribute("pageMaker", pagingVO2);

		return "testBoardPage";
	}
	
	@RequestMapping("/boardPage")
	public String BoardPage(Model model,PagingVO vo) {
		ArrayList<BoardMemberVO> list = boardService.getBoardList(vo);
		model.addAttribute("boardDataList",list);
		
		PagingVO2 pagingVO2 = new PagingVO2();
		pagingVO2.setPagingVO(vo);
		
		//검색xx
		if(vo.getSearchTarget() == null) {
			pagingVO2.setTotalCount(boardService.boardListCount());
			System.out.println("검색XXXX : " + pagingVO2.getTotalCount());
			
		//닉넴검색
		}else if(vo.getSearchTarget().equals("m_nickname")) {
			pagingVO2.setTotalCount(boardService.countSearchNick(vo));
			System.out.println("닉네임 검색  : " + pagingVO2.getTotalCount());
			
		//제목or내용 검색
		}else {
			pagingVO2.setTotalCount(boardService.countSearchWord(vo));
			System.out.println("검색 할때 카운 트 : " + pagingVO2.getTotalCount());
		}
		
		model.addAttribute("pageMaker", pagingVO2);
		return "boardPage";
	}

	@RequestMapping("/readContentPage")
	public String readContentPage(BoardVO requestParam,Model model) {
		//조회수증가 
		boardService.updateCount(requestParam);
		
		//댓글가져오기
		ArrayList<CommentBoardVO> commentList = commentService.getCommentList(requestParam.getB_idx());
		model.addAttribute("commentList", commentList);
		
		//원글 가져오기
		BoardMemberVO boardData = boardService.readContent(requestParam);
		model.addAttribute("boardData" , boardData);
		
		return "readContentPage";
	}
	
	@RequestMapping("/writeContentPage")
	public String writeContentPage() {
		return "writeContentPage";
	}
	
	@RequestMapping("/writeContentAction")
	public String writeContentAction(BoardVO requestParam){
		boardService.writeContent(requestParam);
		return "redirect:boardPage";
	}
	
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(String b_idx) {
		BoardVO vo = new BoardVO();
		vo.setB_idx(b_idx);
		
		boardService.deleteContent(vo);
		return "redirect:boardPage";	
	}
	
	@RequestMapping("/updateContentPage")
	public String updateContentPage(BoardVO requestParam, Model model) {
		BoardMemberVO data = boardService.readContent(requestParam);
		model.addAttribute("boardData", data);

		return "updateContentPage";
	}
	
	@RequestMapping("/updateContentAction")
	public String updateContentAction(BoardVO requestParam) {
		boardService.updateContent(requestParam);

		return "redirect:boardPage";
	}

}