package com.ja.mlproject.vo;

// 프로젝트 이름 추가
public class ProjectVO {
	private String p_idx;
	private String p_name;
	private String m_idx;
	private String p_modeltype;
	private String p_query;
	private String p_learnedresult;
	
	public ProjectVO() {
		
	}

	public ProjectVO(String p_idx, String p_name, String m_idx, String p_modeltype, String p_query, String p_learnedresult) {
		super();
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.m_idx = m_idx;
		this.p_modeltype = p_modeltype;
		this.p_query = p_query;
		this.p_learnedresult = p_learnedresult;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}
	
	public String getP_name() {
		return p_name;
	}
	
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getP_modeltype() {
		return p_modeltype;
	}

	public void setP_modeltype(String p_modeltype) {
		this.p_modeltype = p_modeltype;
	}

	public String getP_query() {
		return p_query;
	}

	public void setP_query(String p_query) {
		this.p_query = p_query;
	}

	public String getP_learnedresult() {
		return p_learnedresult;
	}

	public void setP_learnedresult(String p_learnedresult) {
		this.p_learnedresult = p_learnedresult;
	}
	
}
