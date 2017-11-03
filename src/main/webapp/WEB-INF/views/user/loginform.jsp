<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="menu" value="signin" />
<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login form</h3>
					</div>
					<div class="panel-body">
						<form method="post" action="login.do">
							<div class="form-group">
								<label>Id</label>
								<input type="text" class="form-control" id="user-id" name="userid">
							</div>
							<div class="form-group">
								<label>Password</label>
								<input type="password" class="form-control" id="user-pwd" name="userpwd">
							</div>
							<div class="form-group text-right">
								<button type="submit" class="btn btn-primary btn-sm">Login</button>
								<a href="/home.do" class="btn btn-default btn-sm">Cancel</a>
							</div>
						</form>
					</div>
					<c:if test="${param.error eq 'fail' }">
						<div class="panel-footer">
							<p class="text-danger">아이디 혹은 비밀번호가 일치하지 않습니다.</p>
						</div>
					</c:if>
					<c:if test="${param.error eq 'deny' }">
						<div class="panel-footer">
							<p class="text-danger">로그인이 필요한 서비스 입니다.</p>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>