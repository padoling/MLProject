package com.ja.mlproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.mlproject.vo.DataFileVO;

public interface DataFileSQLMapper {
	@Insert("INSERT INTO ML_DataFile VALUES(ML_DataFile_Seq.NEXTVAL, #{m_idx}, #{d_orifilename}, #{d_filelink})")
	public void insert(DataFileVO vo);
	
	@Select("SELECT * FROM ML_DataFile WHERE m_idx = #{m_idx} ORDER BY d_idx DESC")
	public ArrayList<DataFileVO> selectByM_Idx(String m_idx);
	
	@Select("SELECT * FROM ML_DataFile WHERE d_idx = #{d_idx}")
	public DataFileVO selectByD_Idx(String d_idx);
}
