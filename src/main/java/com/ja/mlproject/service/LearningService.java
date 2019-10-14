package com.ja.mlproject.service;

import java.util.ArrayList;

import com.ja.mlproject.vo.DataFileVO;
import com.ja.mlproject.vo.ProjectVO;

public interface LearningService {
	
	public ArrayList<ProjectVO> getMyProjectList(String m_idx);
	
	public ProjectVO createProject(ProjectVO vo);
	
	public ProjectVO getSelectedProject(ProjectVO vo);
	
	public DataFileVO insertDataFile(DataFileVO vo);
	
	public DataFileVO getFilePath(String d_idx);
	
}
