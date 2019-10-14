package com.ja.mlproject.vo;

public class SessionVO {
	private String sessionIdx;
	private String sessionNickname;
	
	public SessionVO() {
		
	}

	public SessionVO(String sessionIdx, String sessionNickname) {
		super();
		this.sessionIdx = sessionIdx;
		this.sessionNickname = sessionNickname;
	}

	public String getSessionIdx() {
		return sessionIdx;
	}

	public void setSessionIdx(String sessionIdx) {
		this.sessionIdx = sessionIdx;
	}

	public String getSessionNickname() {
		return sessionNickname;
	}

	public void setSessionNickname(String sessionNickname) {
		this.sessionNickname = sessionNickname;
	}
	
}
