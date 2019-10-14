<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
    <form action="./writeContentAction" method="post">
      <div class="form-group">
        <label for="writer">작성자</label>
        <br>
        <h3>${sessionData.sessionNickname }</h3>
      </div>
      <div class="form-group">
        <label for="subject">제목</label>
        <input type="text" class="form-control" id="subject" name="b_title" placeholder="제목을 입력하세요.">
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="b_content" rows="20"></textarea>
      </div>
      <input type = "hidden" name="m_idx" value="${sessionData.sessionIdx }">
      <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>