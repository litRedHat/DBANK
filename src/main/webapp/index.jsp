<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>直销银行</title>
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript" src="resource/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.json-2.4.js"></script>
<script type="text/javascript">
	function ajaxRequest() {
		$.ajax({
			url : "http://localhost:8080/DBANK/hello.html",
			type : "POST",
			dataType : "json",
			//contentType : "application/x-www-form-urlencoded; charset=utf-8",
			contentType : "application/json; charset=utf-8",
			data : $.toJSON({
				USER_ID : "6225882140083202"
			}),
			/* data : {
				USER_ID : "6225882140083202"
			}, */
			async : false,
			success : function(data) {
				alert(data.xml);
			},
			error : function() {
				alert("error");
			}
		});
	}

	function sendEmail() {
		$.ajax({
			url : "http://localhost:8888/DBANK/sendEmail.html",
			type : "POST",
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			data : $.toJSON({
				USER_ID : "6225882140083202"
			}),
			async : false,
			success : function(data) {
				alert(data.resFlag);
			},
			error : function() {
				alert(data.resFlag);
			}
		});
	}
</script>
</head>

<body ng-app='httpRequestModule'>
<img alt="" src="logo.png"><br>
request.getContextPath():<%=request.getContextPath() %></br>
request.getServletPath():<%=request.getServletPath() %></br>
request.getScheme():<%=request.getScheme()%></br>
request.getServerName():<%=request.getServerName()%></br>
request.getServerPort():<%=request.getServerPort()%></br>
request.getRequestURL():<%=request.getRequestURL()%></br>
	<input type="button" onclick="ajaxRequest()" value="Ajax-POST"></input>
	<input type="button" onclick="sendEmail()" value="SendEmail"></input>

	<div ng-controller="HttpController">
		<button ng-click="submit()">Angular-POST</button>
		<button ng-click="reset()">Angular-GET</button>
	</div>
	<script src="resource/js/angular.js"></script>
	<script>
		var httpRequestModule = angular.module('httpRequestModule', []);
		httpRequestModule.controller('HttpController', function HttpController(
				$scope, $http) {

			$scope.submit = function() {
				var data = {
					USER_ID : '6225882140083202'
				};
				var config = {
					'Content-Type' : 'application/json; charset=utf-8'
				}
				$http.post('hello.html', data, config).success(function(data) {
					alert('success');
				}).error(function(data) {
					alert('error');
				});
			}

			$scope.reset = function() {
				$http.get('hello.html', {
					params : {
						USER_ID : '6225882140083201'
					}
				}).success(function(data) {
					alert(data.xml);
				});
			}
		});
	</script>
</body>
</html>