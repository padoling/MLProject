package com.ja.mlproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.ja.mlproject.mapper.MemberSQLMapper;
import com.ja.mlproject.service.MemberService;
import com.ja.mlproject.util.MailUtils;
import com.ja.mlproject.util.RandKey;
import com.ja.mlproject.vo.MemberVO;
import com.ja.mlproject.vo.SessionVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void joinMemberProcess(MemberVO vo) {
		// 랜덤 authkey 생성
		String authkey = new RandKey().getKey(10, false);
		System.out.println("생성된 authkey : " + authkey);
		
		// vo 객체에 authkey 넣은 뒤 DB에 insert
		vo.setM_authkey(authkey);
		memberSQLMapper.insert(vo);
		
		System.out.println("insert 성공");
		
		// mail 작성
		MailUtils sendMail = new MailUtils(mailSender);
		
		sendMail.setSubject("[ML Project] 회원가입 이메일 인증");
		sendMail.setText(new StringBuffer().append("<h1>이메일 인증</h1>")
						.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
						.append("<a href='http://localhost/mlproject/joinMemberConfirmAction?m_id=")
						.append(vo.getM_id())
						.append("&m_authkey=")
						.append(authkey)
						.append("'>이메일 인증 확인</a>")
						.toString());
		sendMail.setFrom("padoling920@gmail.com", "MLProject");
		sendMail.setTo(vo.getM_id());
		sendMail.send();
	}

	@Override
	public void joinConfirmProcess(MemberVO vo) {
		vo.setM_authstatus("2");
		memberSQLMapper.updateAuthstatus(vo);
	}

	@Override
	public SessionVO loginProcess(MemberVO vo) {
		MemberVO selectedVO = memberSQLMapper.selectById(vo.getM_id());
		SessionVO sessionVO = null;
		if(selectedVO != null && selectedVO.getM_password().equals(vo.getM_password()) && selectedVO.getM_authstatus().equals("2")) {
			System.out.println("로그인 성공");
			// 로그인 성공했을 때만 sessionVO에 값 저장
			sessionVO = new SessionVO(selectedVO.getM_idx(), selectedVO.getM_nickname());
		}
		
		return sessionVO;
	}

	@Override
	public MemberVO searchByNickname(String m_nickname) {
		MemberVO memberVO = new MemberVO();
		memberVO = memberSQLMapper.selectByNickname(m_nickname);

		return memberVO;
	}

	@Override
	public boolean confirmIdProcess(String m_id) {
		MemberVO memberVO = memberSQLMapper.selectById(m_id);
		if(memberVO != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean confirmNicknameProcess(String m_nickname) {
		MemberVO memberVO = memberSQLMapper.selectByNickname(m_nickname);
		if(memberVO != null) {
			return false;
		} else {
			return true;
		}
	}
	
}
