package com.ja.mlproject.vo;

public class CommentBoardVO {
	
	private String c_idx;
	private String b_idx;
	private String m_idx;
	private String m_nickname;
	private String c_comment;
	private String c_writedate;
	
	public CommentBoardVO() {
		
		
	}

	public CommentBoardVO(String c_idx, String b_idx, String m_idx, String m_nickname, String c_comment,
			String c_writedate) {
		super();
		this.c_idx = c_idx;
		this.b_idx = b_idx;
		this.m_idx = m_idx;
		this.m_nickname = m_nickname;
		this.c_comment = c_comment;
		this.c_writedate = c_writedate;
	}

	public String getC_idx() {
		return c_idx;
	}

	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

	public String getC_writedate() {
		return c_writedate;
	}

	public void setC_writedate(String c_writedate) {
		this.c_writedate = c_writedate;
	}
	
	
	

}