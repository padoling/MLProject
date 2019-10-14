package com.ja.mlproject.vo;

public class PagingVO {
	
	
	 private String searchWord;
	 private String searchTarget;
	 private String m_idx;
	 private int page;
	 private int perPageNum;
	 private int rowStart;
	 private int rowEnd;
	 
	 public PagingVO(){
	  this.page = 1;
	  this.perPageNum = 10;
	 }

	 public void setPage(int page)
	 {
	  if (page <= 0)
	  {
	   this.page = 1;
	   return;
	  }
	  this.page = page;
	 }

	 public void setPerPageNum(int perPageNum)
	 {
	  if (perPageNum <= 0 || perPageNum > 100)
	  {
	   this.perPageNum = 10;
	   return;
	  }
	  this.perPageNum = perPageNum;
	 }

	 public int getPage()
	 {
	  return page;
	 }
	 
	 //생략가능
	 public int getPageStart()
	 {
	  return (this.page - 1) * perPageNum;
	 }

	 public int getPerPageNum()
	 {
	  return this.perPageNum;
	 }

	 @Override
	 
	 public String toString() {
	  return "PagingVO [page=" + page + ", perPageNum=" + perPageNum + ""
	    + ", rowStart=" + getRowStart() + ", rowEnd=" + getRowEnd()
	    + "]";
	 }

	 public int getRowStart() {
	  rowStart = ((page - 1) * perPageNum) + 1;
	  return rowStart;
	 }

	 public int getRowEnd() {
	  rowEnd = rowStart + perPageNum - 1;
	  return rowEnd;
	 }

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchTarget() {
		return searchTarget;
	}

	public void setSearchTarget(String searchTarget) {
		this.searchTarget = searchTarget;
	}

	public PagingVO(String searchWord, String searchTarget) {
		super();
		this.searchWord = searchWord;
		this.searchTarget = searchTarget;
	}

	public PagingVO(String m_idx) {
		super();
		this.m_idx = m_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	 
	 
	 
	}