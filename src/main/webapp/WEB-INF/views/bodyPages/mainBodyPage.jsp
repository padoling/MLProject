<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<!-- jumbotron -->
	<div class="jumbotron">
		<h1 class="display-4">MLProject - Machine Learning Project</h1>
		<p class="lead">웹 사이트를 통한 쉽고 빠른 Machine Learning</p>
		<hr class="my-4">
		<p>MLProject는 기계학습 툴을 사용하여 모델을 학습시키고 테스트할 수 있는 학습용 사이트입니다.<br>
		별도의 프로그램 설치 없이 MLProject를 통해 기계학습의 원리를 익혀보세요.<br>
		또한, Board에서 다른 유저와 질문을 주고받을 수 있습니다.<br>
		(현재 모델은 MLP만 이용 가능하며, 다른 모델과 서비스는 추후 개발 예정입니다.)</p>
	</div>
	
	<!-- menu -->
	<div class="container marketing">
		<div class="row">
			<div class="col-lg-6">
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#FFBDA3" />
					<text x="50%" y="50%" fill="white" dy=".3em" font-size="40" font-family="LeckerliOne">ML</text>
				</svg>
				<h2>기계학습 프로그램</h2>
				<p>기계학습 모델을 직접 구성하여 데이터를 학습시킬 수 있는 프로그램입니다.
					학습시킬 데이터를 업로드하고, 드래그 앤 드롭으로 모델의 계층을 조정해보세요.</p>
				<c:choose>
				<c:when test="${!empty sessionData }">
					<p><a class="btn btn-secondary" href="./programUsingPage" role="button">사용하기 &raquo;</a></p>
				</c:when>
				<c:otherwise>
					<p><a class="btn btn-secondary" href="./loginPage" role="button">사용하기 &raquo;</a></p>
				</c:otherwise>
				</c:choose>
			</div>
			<!-- /.col-lg-6 -->
			
			<div class="col-lg-6">
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#FFBDA3" />
					<text x="50%" y="50%" fill="white" dy=".3em" font-size="40" font-family="LeckerliOne">Board</text>
				</svg>
				<h2>게시판</h2>
				<p>다른 유저들과 소통할 수 있는 게시판입니다.
					기계학습에 관한 정보나 질문을 함께 나눠보세요.</p>
				<p><a class="btn btn-secondary" href="./boardPage" role="button">이용하기 &raquo;</a></p>
			</div>
			<!-- /.col-lg-6 -->
			
		</div>
		<!-- /.row -->
	</div>