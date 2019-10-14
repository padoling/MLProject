package com.ja.mlproject.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ja.mlproject.vo.MemberVO;

public interface MemberSQLMapper {
	@Insert("INSERT INTO ML_Member VALUES(ML_Member_Seq.NEXTVAL, #{m_id}, #{m_password}, #{m_nickname}, #{m_authkey}, 1)")
	public void insert(MemberVO vo);
	
	@Select("SELECT * FROM ML_Member WHERE m_id = #{m_id}")
	public MemberVO selectById(String m_id);
	
	@Select("SELECT * FROM ML_Member WHERE m_idx = #{m_idx}")
	public MemberVO selectByIdx(String m_idx);
	
	@Update("UPDATE ML_Member SET m_authstatus = #{m_authstatus} WHERE m_id = #{m_id}")
	public void updateAuthstatus(MemberVO vo);
	
	@Update("UPDATE ML_Member SET m_password = #{m_password} WHERE m_idx = #{m_idx}")
	public void updatePassword(MemberVO vo);
	
	@Delete("DELETE FROM ML_Member WHERE m_idx = #{m_idx}")
	public void deleteByIdx(String m_idx);
	
	//닉네임 검색
	@Select("SELECT * FROM ML_Member WHERE M_nickname = #{m_nickname}")
	public MemberVO selectByNickname(String m_nickname);
}
