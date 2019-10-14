package com.ja.mlproject.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ja.mlproject.mapper.DataFileSQLMapper;
import com.ja.mlproject.mapper.ProjectSQLMapper;
import com.ja.mlproject.service.LearningService;
import com.ja.mlproject.vo.DataFileVO;
import com.ja.mlproject.vo.ProjectVO;

@Service
public class LearningServiceImpl implements LearningService {
	
	@Autowired
	private ProjectSQLMapper projectSQLMapper;
	
	@Autowired
	private DataFileSQLMapper dataFileSQLMapper;

	@Override
	public ArrayList<ProjectVO> getMyProjectList(String m_idx) {
		ArrayList<ProjectVO> projectList = projectSQLMapper.selectByM_idx(m_idx);
		
		return projectList;
	}

	@Override
	@Transactional
	public ProjectVO createProject(ProjectVO vo) {
		projectSQLMapper.insert(vo);
		
		ArrayList<ProjectVO> projectList = projectSQLMapper.selectByM_idx(vo.getM_idx());
		ProjectVO selectedProject = projectList.get(0);
		
		return selectedProject;
	}

	@Override
	public ProjectVO getSelectedProject(ProjectVO vo) {
		ProjectVO selectedProject = projectSQLMapper.selectByIdx(vo);
		
		return selectedProject;
	}

	@Override
	@Transactional
	public DataFileVO insertDataFile(DataFileVO vo) {
		System.out.println(vo.getD_orifilename());
		dataFileSQLMapper.insert(vo);
		
		ArrayList<DataFileVO> dataFileList = dataFileSQLMapper.selectByM_Idx(vo.getM_idx());
		DataFileVO selectedFile = dataFileList.get(0);
		
		return selectedFile;
	}

	@Override
	public DataFileVO getFilePath(String d_idx) {
		DataFileVO filepath = dataFileSQLMapper.selectByD_Idx(d_idx);
		
		return filepath;
	}

}
