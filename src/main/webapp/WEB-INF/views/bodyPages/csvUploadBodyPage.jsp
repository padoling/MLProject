<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 경고 바 -->
	<div id="alert" class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none">
    	적용버튼을 눌러 csv 파일이 적용됐는지 먼저 확인해주세요.
	  <button type="button" class="close" onclick="alertclose()">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
    <div id="wrapper">
    	<div class="container">
    		<div>모델을 학습시킬 때 사용할 데이터 파일을 업로드합니다.</div>
    		<!-- csv파일 업로드 창 -->
    		<form id="upload_file" action="./fileUploadAction" method="post" enctype="multipart/form-data">
				<div class="form-group row">
					<label for="customFile" class="col-sm-3 col-form-label">csv 파일 선택</label>
					<div class="custom-file col-sm-9">
					  <input type="file" accept=".csv" class="custom-file-input" id="customFile" name="file" onchange="check_upload_reset()">
					  <label class="custom-file-label" for="customFile">Choose csv file</label>
					</div>
				</div>
				<div id="comment">
					* csv파일의 첫번째 행에 각 열의 이름이 들어있는지 확인해주세요.<br>
					* y label로 설정할 열을 제외한 모든 열이 x label인지 확인해주세요.<br>
					두 사항 모두 확인 후 아래 "적용" 버튼을 눌러주세요.
				</div>
				<button type="button" class="btn btn-outline-warning" onclick="upload_file()">적용</button>
			</form>
			
			<button type="button" id="btn_submit" class="btn btn-primary btn-lg" onclick="projectPageSubmit()">next</button>
			
    	</div>
    </div>
    
	<!-- 파일명 보이게 하는 플러그인 -->
    <script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input/dist/bs-custom-file-input.js" type="text/javascript"></script>
    
    <script>
	 	// 파일명 보이게 하는 플러그인 실행
		$(document).ready(function() {
			bsCustomFileInput.init();
		})
		
		// 변수 선언...
		var d_idx = null;
	 	var index = null;
	 	var check_upload = false;
	 	var comment = '* csv파일의 첫번째 행에 각 열의 이름이 들어있는지 확인해주세요.<br>* y label로 설정할 열을 제외한 모든 열이 x label인지 확인해주세요.<br>두 사항 모두 확인 후 아래 "적용" 버튼을 눌러주세요.';
	 	
	 	// 적용버튼 누른 것 리셋
	 	function check_upload_reset() {
	 		check_upload = false;
	 		document.getElementById("comment").innerHTML = comment;
		}
		
		// 파일 업로드하고 index 불러오기
		function upload_file() {
	        var formData = new FormData(document.getElementById("upload_file"));

	        $.ajax({
	            url: './fileUploadAction',
	            async: true,
	            processData: false,
	            contentType: false,
	            data: formData,
	            type: 'POST',
            	success : function(data) {
            		d_idx = data.d_idx;
					index = data.index;
					console.log(d_idx);
					console.log(index);
					check_upload = true;
					document.getElementById("comment").innerHTML = '적용되었습니다.';
				},
				error : function(error) {
					alert("error : " + error);
				}
	        });
	        
	    }
	 	
		// projectPage로 이동하면서 데이터 넘기기
	 	function projectPageSubmit() {
	 		
	 		if(check_upload == false) {
				$('.alert').alert();
				$('#alert').show();
				
	 		} else {
	 			var form = document.createElement("form");
		 		form.setAttribute("method", "Post");
		 		form.setAttribute("action", "./projectPage");
				
		 		var formData = {
		 			m_idx : '<c:out value="${m_idx}" />',
		 			p_idx : '<c:out value="${p_idx}" />',
		 			d_idx : d_idx,
		 			index : index
		 		}
		 		
				for(var key in formData) {
					var hiddenField = document.createElement("input");
			        hiddenField.setAttribute("type", "hidden");
			        hiddenField.setAttribute("name", key);
			        hiddenField.setAttribute("value", formData[key]);
			        form.appendChild(hiddenField);
				}
				
		 		document.body.appendChild(form);
		 		form.submit();
	 		}	
	 	}
	 	
	 	// 경고창 닫기 버튼
		function alertclose() {
			$('.alert').hide();
		}
    </script>