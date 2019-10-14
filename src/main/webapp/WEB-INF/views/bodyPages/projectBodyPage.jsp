<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div id="wrapper">
		<div id="main" class="rounded">
			<!-- 프로젝트 이름 및 모델 유형 표시 -->
			<div id="title" class="row justify-content-start">
				<div class="col-4">Project : ${selectedProject.p_name }</div>
				<div class="col-4">Model : ${selectedProject.p_modeltype }</div>
			</div>
	
			<!-- 인덱스 숫자/문자 설정 -->
			<div class="row px-4">
				<div class="col-6">
					<div>인덱스 선택</div>
					<div>(데이터 유형에 따라 숫자와 문자를 구분해주세요.)</div>
				</div>
				<div class="col-6"></div>
			</div>
	
			<div class="row px-4 pb-4">
				<div class="col-6">
					<div style="width: 100%; height: 200px; overflow: auto">
						<table class="table">
						
							<thead>
								<tr>
									<th scope="col">No.</th>
									<th scope="col">Check</th>
									<th scope="col">Name</th>
								</tr>
							</thead>
	
							<tbody>
								<c:forEach var="list" items="${list }" varStatus="status">
									<tr>
										<th scope="row" id="indexCount">${status.count }</th>
										<td>
											<input type="radio" name="check_${status.count }" value="num">숫자
											<input type="radio" name="check_${status.count }" value="str">문자
										</td>
										<td>${list }</td>
									</tr>
								</c:forEach>
							</tbody>
	
						</table>
					</div>
					<div align="center">
						<button type="button" class="btn btn-primary" onclick="checkNumOrStr();">확인</button>
						<button type="button" class="btn btn-primary" onclick="checkFirstYlabel();">y-label 시작</button>
						<button type="button" class="btn btn-primary" onclick="checkLastYlabel();">y-label 끝</button>
					</div>
				</div>
	
				<div class="col-6">
					<div style="width: 100%; height: 200px; overflow: auto">
						<table class="table">
							<tbody>
								<tr>
									<th scope="row">숫자</th>
									<td id="numberDiv"></td>
								</tr>
								<tr>
									<th scope="row">문자</th>
									<td id="stringDiv"></td>
								</tr>
								<tr class="table-active">
									<th scope="row">y-label 시작</th>
									<td id="fistYlabelDiv"></td>
								</tr>
								<tr class="table-active">
									<th scope="row">y-label 끝</th>
									<td id="lastYlabelDiv"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			<!-- end of row -->
			</div>
	
			<!-- 파라미터 드래그 앤 드롭 -->
			<div class="row px-4">
				<div class="col-6">
					<div>파라미터</div>
				</div>
				<div class="col-6">
					<div>구성된 모델</div>
				</div>
			</div>
	
			<div class="row px-4 pb-5">
				<!-- drag area -->
				<div class="col-6">
					<div id="parameters">
	
						<!-- first row -->
						<div class="row">
							<div class="col-6">
								<!-- input layer -->
								<div id="input_layer" class="p-3">
									Input layer
									<div id="input_layer_box" class="border border-dark pt-2 px-2">
										<div id="InputLayer_CSV" class="mb-2 p-2 bg-primary text-white rounded" 
										draggable="true" ondragstart="drag(event)">InputLayer</div>
									</div>
								</div>
							</div>
	
							<div class="col-6">
								<!-- summation layer -->
								<div id="summation_layer" class="p-3">
									Summation layer
									<div id="summation_layer_box"
										class="border border-dark pt-2 px-2">
										<div id="Perceptron" class="mb-2 p-2 bg-warning text-white rounded" 
										draggable="true" ondragstart="drag(event)">
											Perceptron
											<div class="form-group row" id="perceptron_form">
												<label for="num_of_perceptron"
													class="col-sm-4 col-form-label">개수</label>
												<div class="col-sm-8">
													<input type="text" class="form-control form-control-sm"
														id="num_of_perceptron">
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">Last?</div>
												<div class="col-sm-8">
													<div class="form-check">
														<input class="form-check-input" type="checkbox"
															id="final_layer">
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
	
						<!-- second row -->
						<div class="row">
							<div class="col-6">
								<!-- activation layer -->
								<div id="activation_layer" class="p-3">
									Activation layer
									<div id="activation_layer_box"
										class="border border-dark pt-2 px-2">
										<div id="Activation_Sigmoid" class="mb-2 p-2 bg-info text-white rounded" draggable="true"
											ondragstart="drag(event)">Activation:Sigmoid</div>
										<div id="Activation_Softplus" class="mb-2 p-2 bg-info text-white rounded" draggable="true"
											ondragstart="drag(event)">Activation:Softplus</div>
										<div id="Activation_Softmax" class="mb-2 p-2 bg-info text-white rounded" draggable="true"
											ondragstart="drag(event)">Activation:Softmax</div>
										<div id="Activation_Relu" class="mb-2 p-2 bg-info text-white rounded" draggable="true"
											ondragstart="drag(event)">Activation:Relu</div>
										<div id="Activation_HyperbolicTangent" class="mb-2 p-2 bg-info text-white rounded" draggable="true"
											ondragstart="drag(event)">Activation:HyperbolicTangent</div>
									</div>
								</div>
							</div>
	
							<div class="col-6">
								<!-- cost layer -->
								<div id="cost_layer" class="p-3">
									Cost layer
									<div id="cost_layer_box" class="border border-dark pt-2 px-2">
										<div id="MeanSquaredError" class="mb-2 p-2 bg-success text-white rounded"
											draggable="true" ondragstart="drag(event)">Cost:MeanSquaredError</div>
										<div id="Entropy" class="mb-2 p-2 bg-success text-white rounded"
											draggable="true" ondragstart="drag(event)">Cost:Entropy</div>
									</div>
								</div>
							</div>
						</div>
	
						<!-- third row -->
						<div class="row">
							<div class="col-6">
								<!-- learning algorithm layer -->
								<div id="learning_algorithm_layer" class="p-3">
									Learning algorithm layer
									<div id="learning_algorithm_layer_box" class="border border-dark pt-2 px-2">
										<div id="StochasticGradientDescent" class="mb-2 p-2 bg-danger text-white rounded" 
											draggable="true" ondragstart="drag(event)">StochasticGradientDescent</div>
									</div>
								</div>
							</div>
	
							<div class="col-6"></div>
						</div>
	
						<!-- end of parameters -->
					</div>
					<!-- end of col-6 -->
				</div>
	
				<!-- drop area -->
				<div class="col-6">
					<div id="parameters_drop" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
	
					<!-- buttons -->
					<div id="parameter_button" class="float-right">
						<button type="button" class="btn btn-primary">전체 삭제</button>
						<button type="button" class="btn btn-primary" onclick="make_query()">실행</button>
					</div>
				</div>
	
				<!-- end of row -->
			</div>
	
			<!-- 학습결과창 -->
			<div class="row px-4">
				<div class="col-12">
					<div>학습 결과</div>
				</div>
			</div>
	
			<div class="row px-4 pb-4">
				<div class="col" style="min-height: 400px; background-color: #fff">
					<img id="resultimg" class="img-fluid" alt="Responsive image">
				</div>
			</div>
	
			<!-- end of main -->
		</div>
		<!-- end of wrapper -->
	</div>
	
	
	
	<script>
		// 인덱스 체크를 위한 변수
		var y_label_index_starting = 0;
		var y_label_index_last = 0;
		
		// 숫자인지 문자인지 체크(아직 실행 안됨ㅠㅠ)
		function checkNumOrStr() {
			var i = 0
			var numberIndex = '';
			var stringIndex = '';
			for (var index in "<c:out value='${list}'/>") {
				i++;
				var radio = document.getElementsByName('check_'+String(i));
				console.log(index)
				console.log(radio)
				if(radio[0].checked) {
					numberIndex += index + ' ';
				} else if(radio[1].checked) {
					stringIndex += index + ' ';
				}
			}
			document.getElementById("numberDiv").innerHTML = numberIndex;
			document.getElementById("stringDiv").innerHTML = stringIndex;
		}
	
		// 숫자인 인덱스 체크
		function checkNumber() {
			var size = document.getElementsByName("checkBox").length;
			var numberIndex = '';
			for (var i = 0; i < size; i++) {
				if (document.getElementsByName("checkBox")[i].checked == true) {
					numberIndex += document.getElementsByName("checkBox")[i].value + ' ';
					document.getElementsByName("checkBox")[i].checked = false;
				}
			}
	
			var numberDiv = document.getElementById("numberDiv");
			numberDiv.innerHTML = numberIndex;
		}
	
		// 문자인 인덱스 체크
		function checkString() {
			var size = document.getElementsByName("checkBox").length;
			var stringIndex = '';
			for (var i = 0; i < size; i++) {
				if (document.getElementsByName("checkBox")[i].checked == true) {
					stringIndex += document.getElementsByName("checkBox")[i].value + ' ';
					document.getElementsByName("checkBox")[i].checked = false;
				}
			}
	
			var stringDiv = document.getElementById("stringDiv");
			stringDiv.innerHTML = stringIndex;
		}
	
		// y_label_index_starting 체크
		function checkFirstYlabel() {
			var size = document.getElementsByName("checkBox").length;
			var firstYlabel = '';
	
			for (var i = 0; i < size; i++) {
				if (document.getElementsByName("checkBox")[i].checked == true) {
					firstYlabel += 'y라벨 시작 :' + document.getElementsByName("checkBox")[i].value;
					y_label_index_starting = i;
					document.getElementsByName("checkBox")[i].checked = false;
				}
			}
	
			var fistYlabelDiv = document.getElementById("fistYlabelDiv");
			fistYlabelDiv.innerHTML = firstYlabel;
	
			console.log('첫번쨰 y라벨 : ' + y_label_index_starting);
		}
	
		// y_label_index_last
		function checkLastYlabel() {
			var size = document.getElementsByName("checkBox").length;
			var lastYlabel = '';
	
			for (var i = 0; i < size; i++) {
				if (document.getElementsByName("checkBox")[i].checked == true) {
					lastYlabel += 'y라벨 끝 :' + document.getElementsByName("checkBox")[i].value;
					y_label_index_last = i;
					document.getElementsByName("checkBox")[i].checked = false;
				}
			}
	
			var lastYlabelDiv = document.getElementById("lastYlabelDiv");
			lastYlabelDiv.innerHTML = lastYlabel;
	
			console.log('마지막 y라벨 : ' + y_label_index_last);
		}
	
		// perceptron input 숨기기
	
		// drag
		function drag(ev) {
			ev.dataTransfer.setData("text/html", ev.target.id);
		}
	
		// allowDrop
		function allowDrop(ev) {
			ev.preventDefault();
		}
	
		// drop
		function drop(ev) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text/html");
			var nodeCopy = document.getElementById(data).cloneNode(true);
	
			// node끼리 겹쳐지지 않게 하기 위한 코드...
			var el = ev.target;
			if (el.id != 'parameters_drop') {
				el = el.parentNode;
			}
			el.appendChild(nodeCopy);
	
			// 복사된 node의 id에 "_new" 붙이기...
			nodeCopy.id = document.getElementById(data).getAttribute("id") + "_new";
			nodeCopy.draggable = false;
			console.log(nodeCopy.id);
		}
	
		// 쿼리 만들고 보내기
		function make_query() {
			var numOfNode = $("#parameters_drop").children().length;
			console.log("node 개수 : " + numOfNode);
	
			var query = '';
	
			for (i = 0; i < numOfNode; i++) {
				var node = $("#parameters_drop").children().eq(i);
				var node_id = $("#parameters_drop").children().eq(i).attr('id');
	
				var temp_string = '(';
				
				if (node_id == 'InputLayer_CSV_new') {
					temp_string += 'y_label_index_starting=';
					temp_string += y_label_index_starting;
					temp_string += ',y_label_index_last=';
					temp_string += y_label_index_last;
					temp_string += ')'
					
					node_id = node_id.replace('_new', temp_string);
					
				} else if (node_id == 'Perceptron_new') {
					// Perceptron
					var num_of_perceptron = node.find('#num_of_perceptron').val();
					var final_layer = node.find('#final_layer').prop('checked');
	
					temp_string += num_of_perceptron;
					if (final_layer == true) {
						temp_string += 'final_layer=True)';
					} else {
						temp_string += ')';
					}
	
					node_id = node_id.replace('_new', temp_string);
	
				} else if (node.find('input').length > 0) {
					// 내부 input을 가진 node
					for (j = 0; j < node.find('input').length; j++) {
						console.log(node.find('input').eq(j).val());
	
						if (node.find('input').eq(j).val() == '') {
							continue;
						} else {
							temp_string += node.find('input').eq(j).attr('id');
							temp_string += '=';
							temp_string += node.find('input').eq(j).val();
							if (j != node.find('input').length - 1) {
								temp_string += ',';
							}
						}
					}
					temp_string += ')'
					node_id = node_id.replace('_new', temp_string);
	
				} else {
					// 그 외
					node_id = node_id.replace('_new', '()');
	
				}
	
				node_id = '§' + node_id;
				query += node_id;
	
			}
	
			query = query.replace(query.charAt(0),
					'<c:out value="${sessionData.sessionIdx}" />' + '$');
			console.log(query);

			
			// json 만들기
			var json = new Object();
			json.filepath = '<c:out value="${d_idx}" />';
			json.query = query;
			console.log(JSON.stringify(json));
	
			// json 보내기
			$.ajax({
				url : './outputJson',
				async : true,
				type : 'POST',
				data : JSON.stringify(json),
				contentType : 'application/json',
				success : function(data) {
					var resultImg = data.resultImg;
					console.log(resultImg);
					document.getElementById("resultimg").src=resultImg;
				},
				error: function(request,status,error) {   
					alert('code:'+request.status+'\n'+'message:'+request.responseText+'\n'+'error:'+error); 
				}
			});
	
		}
	</script>