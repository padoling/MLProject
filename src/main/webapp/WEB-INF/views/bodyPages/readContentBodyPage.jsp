<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

	<div id="wrapper">
		제목 : ${boardData.boardVO.b_title }<br>
		작성자 : ${boardData.memberVO.m_nickname }<br>
		작성일 : ${boardData.boardVO.b_writedate }<br>
		내용 : <br>
		${boardData.boardVO.b_content }<br><br>
		
		<br>
		
		
		<table class="table">
	    <tr>
		<th scope="col"></th>
		<th scope="col"></th>
		<th scope="col"></th>
		
		</tr>
		<c:forEach var="commentList" items="${commentList }">
			<tr>
				<th scope="row">${commentList.m_nickname }</th>
				<td>${commentList.c_comment }</td>
				<c:if test="${sessionData.sessionIdx == commentList.m_idx }">
					<td><a href="./deleteCommentAction?c_idx=${commentList.c_idx }&b_idx=${commentList.b_idx}"><img src="./img/x-img.png" width="10" height="10"></a></td>
				</c:if>	
			</tr>
		</c:forEach>
		</table>
		
		
		<br>
		
		
		<c:if test="${!empty sessionData }">
		<form action = "./writeCommentAction?b_idx=${boardData.boardVO.b_idx}" method="post">
		  <div class="form-group">
		  
		    <label for="exampleInputEmail1">댓글달기</label>
		    <input type="text" class="form-control" name="c_comment" placeholder="댓글을 입력하세요.">
		    <input type = "hidden" name="m_idx" value="${sessionData.sessionIdx }">
			<input type = "hidden" name="m_nickname" value="${sessionData.sessionNickname }">
		  </div>
		  <button type="submit" class="btn btn-primary">댓글달기</button>
		</form>
		</c:if>
		<br>
		<a href="./boardPage">목록으로</a>
		
		<c:if test="${sessionData.sessionIdx == boardData.boardVO.m_idx }">
			<a href="./deleteContentAction?b_idx=${boardData.boardVO.b_idx }">삭제</a>
			<a href="./updateContentPage?b_idx=${boardData.boardVO.b_idx }">수정</a>
		
		</c:if>
	</div>