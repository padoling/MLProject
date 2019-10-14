<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
    <form action="./updateContentAction" method="post">
      <div class="form-group">
        <label for="writer">작성자</label>
        <br>
        <h3>${boardData.memberVO.m_nickname }</h3>
      </div>
      <div class="form-group">
        <label for="subject">제목</label>
        <input type="text" class="form-control" id="subject" name="b_title" value="${boardData.boardVO.b_title }">
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="b_content" rows="20">${boardData.boardVO.b_content }</textarea>
      </div>
      <input type="hidden" name="b_idx" value="${boardData.boardVO.b_idx }">
      <button type="submit" class="btn btn-primary">수정하기</button>
    </form>
</div>