package com.ja.mlproject.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingVO2 {

	

	 private int totalCount;
	 private int startPage;
	 private int endPage;
	 private boolean prev;
	 private boolean next;

	 private int displayPageNum = 5;

	 private PagingVO pagingVO;
	 
	 public void setPagingVO(PagingVO pagingVO) {
	  this.pagingVO = pagingVO;
	 }

	 public void setTotalCount(int totalCount) {
	  this.totalCount = totalCount;
	  calcData();
	  
	 }

	 public int getTotalCount() {
	  return totalCount;
	 }

	 public int getStartPage() {
	  return startPage;
	 }

	 public int getEndPage() {
	  return endPage;
	 }

	 public boolean isPrev() {
	  return prev;
	 }

	 public boolean isNext() {
	  return next;
	 }

	 public int getDisplayPageNum() {
	  return displayPageNum;
	 }

	 public PagingVO getPagingVO() {
	  return pagingVO;
	 }
	 
	 
	 
	 //start page 엔드페이지 계싼할떄.. 검색할떄랑 안할떄 나눠보자..
	 
	 
	 private void calcData() {
		 
	 
	  endPage = (int) (Math.ceil(pagingVO.getPage() / (double)displayPageNum) * displayPageNum);
	  startPage = (endPage - displayPageNum) + 1;
	  
	  int tempEndPage = (int) (Math.ceil(totalCount / (double)pagingVO.getPerPageNum()));
	 
	  
	  if (endPage > tempEndPage){
	   endPage = tempEndPage;
	  }
	  prev = startPage == 1 ? false : true;
	  next = endPage * pagingVO.getPerPageNum() >= totalCount ? false : true;
	  
	  
	 }
	 
	 
	 public String makeQuery(int page){
		 
		 UriComponents uriComponents = null;
		 
		 //검색용
		 if(pagingVO.getSearchTarget() != null) {
			 
			 uriComponents =
				    UriComponentsBuilder.newInstance()
				    .queryParam("page", page)
				    .queryParam("perPageNum", pagingVO.getPerPageNum())
				    .queryParam("searchTarget", pagingVO.getSearchTarget())
				    .queryParam("searchWord", pagingVO.getSearchWord())
				    .build();
				    
				 
		 //그냥 
		 }else {
			 uriComponents = 
			 UriComponentsBuilder.newInstance()
			 .queryParam("page", page)
			 .queryParam("perPageNum", pagingVO.getPerPageNum())
			 .build();
			 
			 
		 }
	 
	  return uriComponents.toUriString();
	 }
	
}