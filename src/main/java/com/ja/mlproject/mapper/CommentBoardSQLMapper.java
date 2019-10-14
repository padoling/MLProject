package com.ja.mlproject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.mlproject.vo.CommentBoardVO;

public interface CommentBoardSQLMapper {
	
	@Insert("INSERT INTO ML_CommentBoard VALUES(ML_CommentBoard_seq.nextval,#{b_idx},#{m_idx},#{m_nickname},#{c_comment},SYSDATE)")                                                    
	public void insertcomment(CommentBoardVO vo);
	
	@Select("SELECT * FROM ML_CommentBoard WHERE b_idx = #{b_idx} ORDER BY c_idx DESC")
	public ArrayList<CommentBoardVO> selectAll(String b_idx);
	
	@Delete("DELETE FROM ML_CommentBoard WHERE c_idx = #{c_idx}")
	public void deleteByIdx(CommentBoardVO vo);

}