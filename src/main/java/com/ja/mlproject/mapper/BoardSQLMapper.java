package com.ja.mlproject.mapper;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ja.mlproject.vo.BoardVO;
import com.ja.mlproject.vo.PagingVO;

public interface BoardSQLMapper {
	
	@Select("SELECT * FROM ML_BOARD ORDER BY b_idx DESC")
	public ArrayList<BoardVO> selectAll();
	
	@Select("SELECT bd2.*FROM(SELECT bd.*, ROWNUM AS rnum FROM(SELECT * FROM ML_Board ORDER BY b_idx DESC) bd)bd2 WHERE rnum BETWEEN #{rowStart} AND #{rowEnd}")
	public ArrayList<BoardVO> selectAllWithPaging(PagingVO vo);
	
	//제목검색, 값이 들어갈 곳에만 #가능, 그 외엔 달라로 가능.
	//@Select("SELECT * FROM BOARD_CONTENTS WHERE C_TITLE LIKE '%${searchWord}%' ORDER BY c_idx DESC")
	@Select("SELECT bd2.*FROM(SELECT bd.*, ROWNUM AS rnum FROM(SELECT * FROM ML_Board WHERE ${searchTarget} LIKE '%'||#{searchWord}||'%' ORDER BY b_idx DESC) bd)bd2 WHERE rnum BETWEEN #{rowStart} AND #{rowEnd}")
	public ArrayList<BoardVO> selectBySearchWord(
			PagingVO vo);
	
	//"SELECT bd2.*FROM(SELECT bd.*, ROWNUM AS rnum FROM(SELECT * FROM ML_Board WHERE M_idx = #{m_idx} ORDER BY b_idx DESC) bd)bd2 WHERE rnum BETWEEN #{rowStart} AND #{rowEnd}"
	
	//닉네임검색용
	@Select("SELECT bd2.*FROM(SELECT bd.*, ROWNUM AS rnum FROM(SELECT * FROM ML_Board WHERE M_idx = #{m_idx} ORDER BY b_idx DESC) bd)bd2 WHERE rnum BETWEEN #{rowStart} AND #{rowEnd}")
	public ArrayList<BoardVO> selectByM_idx(PagingVO vo);
	
	//글 읽기 
	@Select("SELECT * FROM ML_BOARD WHERE b_idx = #{b_idx}")
	public BoardVO selectByIdx(String b_idx); 
	
	//조회수
	@Update("UPDATE ML_BOARD SET b_count = b_count+1 WHERE b_idx=#{b_idx}")
	public void updateCount(BoardVO vo);
	
	//페이징 관련 총 게시물 수 
	@Select("SELECT COUNT(*) FROM ML_BOARD")
	public int boardListCount();
	
	//<제목or내용>검색 게시물수 세기
	@Select("SELECT COUNT(*) FROM ML_BOARD WHERE ${searchTarget} LIKE '%'||#{searchWord}||'%'")
	public int countSearchWord(PagingVO vo);
	
	//닉네임 검색 게시물 수 세기
	@Select("SELECT COUNT(*) FROM ML_BOARD WHERE M_idx = #{m_idx}")
	public int countSearchNick(PagingVO vo);
	
	
	@Insert("INSERT INTO ML_BOARD VALUES(ML_Board_seq.nextval,#{m_idx},#{b_title},#{b_content},SYSDATE,0)")                                                    
	public void insert(BoardVO vo);
	
	@Delete("DELETE FROM ML_BOARD WHERE b_idx = #{b_idx}")
	public void deleteByIdx(String b_idx);
	
	@Update("UPDATE ML_BOARD SET b_title=#{b_title} , b_content=#{b_content} WHERE b_idx=#{b_idx}")
 	public void updateByIdx(BoardVO vo);
	
}