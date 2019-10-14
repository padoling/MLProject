package com.ja.mlproject.vo;

public class BoardVO {
	private String b_idx;
	private String b_classifier;
	private String m_idx;
	private String b_parentidx;
	private String b_title;
	private String b_content;
	private String b_writedate;
	private String b_count;
	
	public BoardVO() {
		
	}

	public BoardVO(String b_idx, String b_classifier, String m_idx, String b_parentidx, String b_title,
			String b_content, String b_writedate, String b_count) {
		super();
		this.b_idx = b_idx;
		this.b_classifier = b_classifier;
		this.m_idx = m_idx;
		this.b_parentidx = b_parentidx;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writedate = b_writedate;
		this.b_count = b_count;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getB_classifier() {
		return b_classifier;
	}

	public void setB_classifier(String b_classifier) {
		this.b_classifier = b_classifier;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getB_parentidx() {
		return b_parentidx;
	}

	public void setB_parentidx(String b_parentidx) {
		this.b_parentidx = b_parentidx;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writedate() {
		return b_writedate;
	}

	public void setB_writedate(String b_writedate) {
		this.b_writedate = b_writedate;
	}

	public String getB_count() {
		return b_count;
	}

	public void setB_count(String b_count) {
		this.b_count = b_count;
	}
	
}
