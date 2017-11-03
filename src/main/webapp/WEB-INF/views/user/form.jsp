<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="menu" value="signup" />
<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="container">
		<h1>회원 가입</h1>
		
		<div class="alert alert-danger" id="error-message-box">
			<strong>Error!</strong><span id="error-message"></span>
		</div>
		
		<form:form id="register-form" action="add.do" method="post" class="well" commandName="userForm">
			<div class="form-group">
				<label>Name</label>
				<form:input type="text" class="form-control" id="fullname" path="fullname" />
				<form:errors path="fullname" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Id</label>
				<form:input type="text" class="form-control" id="id" path="id" />
				<form:errors path="id" cssClass="text-danger"></form:errors>
				<span class="help-block" id="id-help-block"></span>
			</div>
			<div class="form-group">
				<label>password</label>
				<form:input type="password" class="form-control" id="password" path="password" />
				<form:errors path="password" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Birth</label>
				<form:input type="date" class="form-control" id="birth" path="birth" />
				<form:errors path="birth" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input type="text" class="form-control" id="email" path="email" />
				<form:errors path="email" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Phone</label>
				<form:input type="text" class="form-control" id="phone" path="phone" />
				<form:errors path="phone" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group text-right">
				<button type="submit" class="btn btn-primary btn-sm">Register</button>
				<a href="home.do" class="btn btn-default btn-sm">Cancel</a>
			</div>
		</form:form>
	</div>
</body>
<script type="text/javascript">



 $(function(){
	 
	var idcheckpassed = false; 
	
	var nameExp = /^[가-힣]{2,}$/;
	var idPwdExp = /^[a-zA-z0-9]{6,20}$/;
	var emailExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var phoneExp = /^01[016789]-\d{3,4}-\d{4}$/;
	
	$("#error-message-box").hide();
	
	
	$("#id").keyup(function(){
		var userid = $(this).val();
		if(!idPwdExp.test(userid)){
			return; //검사조차하러 가지 않음
		}
		
		$.ajax({
			type:"GET",
			url:"idcheck.do", // data를 저렇게 적으면 idcheck.do?id=hong 이런식으로감
			data:{id:userid},
			dataType:"json",
			success:function(result){
				var used = result.used;
				if(used){
					$("#id-help-block").text("사용중인 아이디 입니다.");
					idcheckpassed = false;
				} else{
					$("#id-help-block").text("사용가능한 아이디 입니다."); // .removeClass('text-danger').addClass('text-success') $과.text중간에 사용가능
					idcheckpassed = true;
				}
			}
		});
	});
	
	$("#register-form").submit(function(){
		
		
		
		if(!$.trim($("#fullname").val())){
			$("#error-message").text("이름은 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!nameExp.test($("#fullname").val())){
			$("#error-message").text("이름은 2글자이상 한글만 가능합니다");
			$("#error-message-box").show();
			return false;
		}
		if(!$.trim($("#id").val())){
			$("#error-message").text("id는 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!idPwdExp.test($("#id").val())){
			$("#error-message").text("id는 6~20글자로 영문자,숫자만 가능합니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!idcheckpassed){ // 아이디 중복검사를 통과했는지도 확인해야 한다.
			$("#error-message").text("아이디 중복검사를 통과하지 못했습니다.");
			$("#error-message-box").show();
			return false;
		}
		
		if(!$.trim($("#password").val())){
			$("#error-message").text("비밀번호는 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!idPwdExp.test($("#password").val())){
			$("#error-message").text("비밀번호는 6~20글자로 영문자,숫자만 가능합니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!$.trim($("#birth").val())){
			$("#error-message").text("생일은 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!$.trim($("#email").val())){
			$("#error-message").text("email은 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!emailExp.test($("#email").val())){
			$("#error-message").text("유효한 이메일 주소형식이 아닙니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!$.trim($("#phone").val())){
			$("#error-message").text("전화번호는 필수입력값입니다.");
			$("#error-message-box").show();
			return false;
		}
		if(!phoneExp.test($("#phone").val())){
			$("#error-message").text("유효한 전화번호 형식이 아닙니다.");
			$("#error-message-box").show();
			return false;
		}
		return true;
	});
}) 
</script>
</html>