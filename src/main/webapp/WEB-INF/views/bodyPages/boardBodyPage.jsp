<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <table class="table">
	    <tr>
		<th scope="col">글 번호</th>
		<th scope="col">제목</th>
		<th scope="col">작성자</th>
		<th scope="col">조회수</th>
		<th scope="col">작성일</th>
		</tr>
		<c:forEach var="boardData" items="${boardDataList }">
			<tr>
				<th scope="row">${boardData.boardVO.b_idx }</th>
				<td><a href ="./readContentPage?b_idx=${boardData.boardVO.b_idx }">${boardData.boardVO.b_title }</a></td>
				<td>${boardData.memberVO.m_nickname }</td>
				<td>${boardData.boardVO.b_count }</td>
				<td>${boardData.boardVO.b_writedate }</td>			
			</tr>
		</c:forEach>
		</table>

		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  <c:if test="${pageMaker.prev}">
		    <li class="page-item">
		      <a class="page-link" href="boardPage${pageMaker.makeQuery(pageMaker.startPage - 1)}"aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		   </c:if>
		   
		   
		     
		   <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		 	 <li class="page-item"><a class="page-link" href="boardPage${pageMaker.makeQuery(idx)}">${idx}</a></li>
		    </c:forEach>
			 
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<li class="page-item">
		    	  <a class="page-link" href="boardPage${pageMaker.makeQuery(pageMaker.endPage + 1)}" aria-label="Next">
		       	 <span aria-hidden="true">&raquo;</span>
		     	 </a>
		   		</li>
		    </c:if>
		    </ul>
		</nav>

		<!-- 글작성 -->
	     <c:if test="${!empty sessionData }"> 
		   <a href="./writeContentPage">글 작성</a>
		</c:if>
			
		<!-- 검색 부분 -->	
		<br><br>
			
		<form action="./boardPage" method="get">
		<select class="form-control" name="searchTarget">
		  <option value="b_title" selected>제목으로 검색</option>
		  <option value="b_content">내용으로 검색</option>
		  <option value="m_nickname">닉네임으로 검색</option>
		</select>
			
		검색 : <input type="text" name="searchWord">
		<input type="submit" value="검색">
			
		</form>
		
	
</div>
			
		
	
		