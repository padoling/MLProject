<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${!empty param.login }">
		<div class="alert alert-danger" role="alert">
		  	로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.
		</div>
	</c:if>
	
	<div class="text-center">
		<form class="form-signin" action="./loginAction" method="post">
			<h1>Sign In</h1>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" name="m_id" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" name="m_password" class="form-control" placeholder="Password" required>
			
			<!-- <div class="checkbox mb-3">
				<label> 
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>