<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<!-- jumbotron -->
	<div class="jumbotron">
		<h1 class="display-4">너무너무 쉬운 머신러닝</h1>
		<p class="lead">머신러닝은 정말 쉬워요! 다같이 배워볼까요? ^^*</p>
		<hr class="my-4">
		<p>체험과 배우기와 툴 사용하기 중 선택하세용</p>
	</div>
	
	<!-- menu -->
	<div class="container marketing">
		<div class="row">
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#FFBDA3" />
					<text x="50%" y="50%" fill="white" dy=".3em" font-size="40" font-family="LeckerliOne">Trial</text>
				</svg>
				<h2>머신러닝 체험</h2>
				<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
					euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
					Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
					Praesent commodo cursus magna.</p>
				<p><a class="btn btn-secondary" href="#" role="button">체험하기 &raquo;</a></p>
			</div>
			<!-- /.col-lg-4 -->
			
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#FFBDA3" />
					<text x="50%" y="50%" fill="white" dy=".3em" font-size="40" font-family="LeckerliOne">Learn</text>
				</svg>
				<h2>머신러닝 배우기</h2>
				<p>Duis mollis, est non commodo luctus, nisi erat porttitor
					ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
					purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo,
					tortor mauris condimentum nibh.</p>
				<p><a class="btn btn-secondary" href="#" role="button">학습하기 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title>
					<rect width="100%" height="100%" fill="#FFBDA3" />
					<text x="50%" y="50%" fill="white" dy=".3em" font-size="40" font-family="LeckerliOne">Tool</text>
				</svg>
				<h2>툴 사용하기</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
					in, egestas eget quam. Vestibulum id ligula porta felis euismod
					semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus.</p>
				<c:choose>
				<c:when test="${!empty sessionData }">
					<p><a class="btn btn-secondary" href="./programUsingPage" role="button">사용하기 &raquo;</a></p>
				</c:when>
				<c:otherwise>
					<p><a class="btn btn-secondary" href="./loginPage" role="button">사용하기 &raquo;</a></p>
				</c:otherwise>
				</c:choose>
			</div>
			<!-- /.col-lg-4 -->
			
		</div>
		<!-- /.row -->
	</div>