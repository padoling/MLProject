package com.ja.mlproject.service;

import com.ja.mlproject.vo.MemberVO;
import com.ja.mlproject.vo.SessionVO;

public interface MemberService {
	
	public void joinMemberProcess(MemberVO vo);
	
	public void joinConfirmProcess(MemberVO vo);
	
	public SessionVO loginProcess(MemberVO vo);
	
	//검색용
	public MemberVO searchByNickname(String m_nickname);
	
	public boolean confirmIdProcess(String m_id);
	
	public boolean confirmNicknameProcess(String m_nickname);
}
