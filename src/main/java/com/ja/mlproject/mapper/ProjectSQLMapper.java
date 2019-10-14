package com.ja.mlproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.mlproject.vo.ProjectVO;

public interface ProjectSQLMapper {
	@Insert("INSERT INTO ML_Project VALUES(ML_Project_Seq.NEXTVAL, #{p_name}, #{m_idx}, #{p_modeltype}, NULL, NULL)")
	public void insert(ProjectVO vo);
	
	@Select("SELECT * FROM ML_PROJECT WHERE m_idx = #{m_idx} ORDER BY p_idx DESC")
	public ArrayList<ProjectVO> selectByM_idx(String m_idx);
	
	@Select("SELECT * FROM ML_PROJECT WHERE m_idx = #{m_idx} AND p_idx = #{p_idx}")
	public ProjectVO selectByIdx(ProjectVO vo);
}
