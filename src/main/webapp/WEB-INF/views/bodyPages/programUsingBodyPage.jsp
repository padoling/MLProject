<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="wrapper">
		<div class="container">
			<!-- buttons -->
			<div class="row">
				<div class="col">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#new-project-modal" data-whatever="@mdo">새 프로젝트 생성...</button>
					<div>새로운 기계학습 모델을 생성합니다.</div>
				</div>
				<div class="col">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#existing-project-modal" data-whatever="@mdo">기존 프로젝트 선택...</button>
					<div>기존에 만들어 둔 모델을 선택해 수정하거나 테스트합니다.</div>
				</div>
			</div>
			
			<!-- new project modal -->
			<!-- 유효성 체크 : 이름 입력 여부 -->
			<div class="modal fade" id="new-project-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">프로젝트 생성</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="./createProjectAction" method="post">
							<div class="modal-body">
									<div class="form-group">
										<label for="project-name" class="col-form-label">프로젝트 이름</label>
										<input type="text" class="form-control" id="project-name" name="p_name">
									</div>
								<div class="form-group">
									<label for="model-select">모델 선택</label> 
									<select class="form-control" id="model-select" name="p_modeltype">
										<option>MLP</option>
										<option>CNN</option>
										<option>RNN</option>
									</select>
								</div>
								<input type="hidden" name="m_idx" value="${sessionData.sessionIdx }">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								<button type="submit" class="btn btn-primary">확인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<!-- existing project modal -->
			<div class="modal fade" id="existing-project-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">프로젝트 선택</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form action="./csvUploadPage" method="post">
							<div class="modal-body">
								<div class="form-group">
									<label for="project-select">프로젝트 선택</label> 
									<select class="form-control" id="project-select" name="p_idx">
										<c:forEach var="projectData" items="${projectList }">
											<option value="${projectData.p_idx }">${projectData.p_name }</option>
										</c:forEach>
									</select>
								</div>
								<input type="hidden" name="m_idx" value="${sessionData.sessionIdx }">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								<button type="submit" class="btn btn-primary">확인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
		</div>
	</div>