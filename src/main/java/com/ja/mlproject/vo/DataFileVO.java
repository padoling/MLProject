package com.ja.mlproject.vo;

public class DataFileVO {
	private String d_idx;
	private String m_idx;
	private String d_orifilename;
	private String d_filelink;
	
	public DataFileVO() {
		
	}

	public DataFileVO(String d_idx, String m_idx, String d_orifilename, String d_filelink) {
		super();
		this.d_idx = d_idx;
		this.m_idx = m_idx;
		this.d_orifilename = d_orifilename;
		this.d_filelink = d_filelink;
	}

	public String getD_idx() {
		return d_idx;
	}

	public void setD_idx(String d_idx) {
		this.d_idx = d_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getD_orifilename() {
		return d_orifilename;
	}

	public void setD_orifilename(String d_orifilename) {
		this.d_orifilename = d_orifilename;
	}

	public String getD_filelink() {
		return d_filelink;
	}

	public void setD_filelink(String d_filelink) {
		this.d_filelink = d_filelink;
	}
	
}
