<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div id="idAlert" class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none">
    	아이디를 확인해주세요.
	  <button type="button" class="close" onclick="alertclose()">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
	<div id="nicknameAlert" class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none">
    	닉네임을 확인해주세요.
	  <button type="button" class="close" onclick="alertclose()">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
    
	<div class="join">
		<form class="form-join needs-validation" novalidate action="./joinMemberAction" method="post">
			<h1 class="text-center">Sign Up</h1>
			<div class="form-group mb-1">
				<label for="inputId">Email</label>
				<input type="email" id="inputId" class="form-control" name="m_id" placeholder="name@email.com" onchange="idValidityReset()" required autofocus>
			</div>
			<button type="button" class="btn btn-outline-primary mb-3" onclick="confirmId()">아이디 중복 확인</button>
			<div id="confirmIdText"></div>
			<div class="form-group">
				<label for="inputPassword">Password</label>
				<input type="password" class="form-control" name="m_password" placeholder="Password" required>
			</div>
			
			<div class="form-group mb-1">
				<label for="inputNickname">Nickname</label>
				<input type="text" id="inputNickname" class="form-control" name="m_nickname" placeholder="Nickname" onchange="nicknameValidityReset()" required>
			</div>
			<button type="button" class="btn btn-outline-primary mb-3" onclick="confirmNickname()">닉네임 중복 확인</button>
			<div id="confirmNicknameText"></div>
			<button type="submit" class="btn btn-primary" id="submit">회원가입</button>
		</form>
	</div>
	
	<script type="text/javascript">
		// 중복 확인 여부
		var checkIdValidity = false;
		var checkNicknameValidity = false;
		
		function idValidityReset() {
			checkIdValidity = false;
		}
		
		function nicknameValidityReset() {
			checkNicknameValidity = false;
		}
		
		// 아이디 중복확인
		function confirmId() {
			// 입력된 id
			var inputId = $("#inputId").val();
			
			// ui
			var confirmIdText = document.getElementById('confirmIdText');
			
			$.ajax({
				async: true,
				type : 'POST',
				data : inputId,
				url : "confirmIdAction",
				dataType : "json",
				contentType : "application/json; charset-UTF-8",
				success : function(data) {
					if(data.isValid == false) {
						confirmIdText.innerText = "이미 등록된 이메일입니다.";
						confirmIdText.style.color = "red";
						checkIdValidity = false;
					} else {
						confirmIdText.innerText = "사용 가능한 이메일입니다.";
						confirmIdText.style.color = "blue";
						checkIdValidity = true;
					}
				},
				error : function(error) {
					alert("error : " + error);
				}
			});
		};
		
		// 닉네임 중복확인
		function confirmNickname() {
			// 입력된 nickname
			var inputNickname = $("#inputNickname").val();
			
			// ui
			var confirmNicknameText = document.getElementById('confirmNicknameText');
			
			$.ajax({
				async: true,
				type : 'POST',
				data : inputNickname,
				url : "confirmNicknameAction",
				dataType : "json",
				contentType : "application/json; charset-UTF-8",
				success : function(data) {
					if(data.isValid == false) {
						confirmNicknameText.innerText = "이미 등록된 닉네임입니다.";
						confirmNicknameText.style.color = "red";
						checkNicknameValidity = false;
					} else {
						confirmNicknameText.innerText = "사용 가능한 닉네임입니다.";
						confirmNicknameText.style.color = "blue";
						checkNicknameValidity = true;
					}
				},
				error : function(error) {
					alert("error : " + error);
				}
			});
		};
		
		// 유효성 검사
		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
		        } else if(checkIdValidity == false) {
		        	event.preventDefault();
					event.stopPropagation();
					$('.alert').alert();
					$('#idAlert').show();
		        } else if(checkNicknameValidity == false) {
		        	event.preventDefault();
					event.stopPropagation();
					$('.alert').alert();
					$('#nicknameAlert').show();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
		
		// 경고창 닫기
		function alertclose() {
			$('.alert').hide();
		}
	</script>
