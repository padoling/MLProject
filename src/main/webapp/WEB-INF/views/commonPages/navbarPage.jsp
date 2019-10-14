<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<!-- navigation bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand h1" href="./mainPage">PearMount</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto h6">
				<li class="nav-item"><a class="nav-link" href="#">Trial</a></li>
				
				<!-- 회원들만 접속 가능한 메뉴... -->
				<c:choose>
				<c:when test="${!empty sessionData }">
					<li class="nav-item"><a class="nav-link" href="#">Educate</a></li>
					<li class="nav-item"><a class="nav-link" href="./programUsingPage">Program</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="./loginPage">Educate</a></li>
					<li class="nav-item"><a class="nav-link" href="./loginPage">Program</a></li>
				</c:otherwise>
				</c:choose>
				
				<li class="nav-item"><a class="nav-link" href="./boardPage">Board</a></li>
			</ul>
			<ul class="navbar-nav">
				<c:choose>
				<c:when test="${!empty sessionData }">
					<li class="nav-item"><a class="nav-link" href="./personalInfoPage">My Page</a></li>
					<li class="nav-item"><a class="nav-link" href="./logoutAction">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="./loginPage">Sign in</a></li>
					<li class="nav-item"><a class="nav-link" href="./joinMemberPage">Sign up</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>