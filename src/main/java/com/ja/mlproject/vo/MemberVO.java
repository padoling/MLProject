package com.ja.mlproject.vo;

public class MemberVO {
	private String m_idx;
	private String m_id;
	private String m_password;
	private String m_nickname;
	private String m_authkey;
	private String m_authstatus;
	
	public MemberVO() {
		
	}

	public MemberVO(String m_idx, String m_id, String m_password, String m_nickname, String m_authkey,
			String m_authstatus) {
		super();
		this.m_idx = m_idx;
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_nickname = m_nickname;
		this.m_authkey = m_authkey;
		this.m_authstatus = m_authstatus;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getM_authkey() {
		return m_authkey;
	}

	public void setM_authkey(String m_authkey) {
		this.m_authkey = m_authkey;
	}

	public String getM_authstatus() {
		return m_authstatus;
	}

	public void setM_authstatus(String m_authstatus) {
		this.m_authstatus = m_authstatus;
	}
	
}
