package com.ja.mlproject.vo;

import java.util.List;

public class CsvVO {
	private String d_idx;
	private List<String> index;

	public CsvVO() {
		
	}

	public CsvVO(String d_idx, List<String> index) {
		super();
		this.d_idx = d_idx;
		this.index = index;
	}

	public String getD_idx() {
		return d_idx;
	}

	public void setD_idx(String d_idx) {
		this.d_idx = d_idx;
	}

	public List<String> getIndex() {
		return index;
	}

	public void setIndex(List<String> index) {
		this.index = index;
	}
	
}
