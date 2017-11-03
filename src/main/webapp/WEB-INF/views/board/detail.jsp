<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="menu" value="board" />
<%@ include file="/WEB-INF/views/include/nav.jsp" %>
<div class="container">
	<h1>게시글</h1>
	
	<table class="table table-condensed">
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="10%">
			<col width="40%">
		</colgroup>
		<tbody>
			<tr>
				<th>제목</th><td colspan="3"><c:out value="${board.title }" /></td>
			</tr>
			<tr>
				<th>번호</th><td>${board.no }</td>
				<th>추천수</th><td>${board.likes }</td>
			</tr>
			<tr>
				<th>작성자</th><td>${board.writer.fullname }</td>
				<th>작성일</th><td><fmt:formatDate value="${board.createdate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<c:if test="${not empty board.filename }">
				<th>첨부파일</th>
				<td colspan="3">${fn:substring(board.filename, 13, fn:length(board.filename)) }
				<a href="filedownload.do?no=${board.no }" class="btn btn-default btn-xs">다운</a></td>
				</c:if>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><c:out value="${board.contents }" /></td>
			</tr>
		</tbody>
	</table>
	<div class="text-right">
		<a href="home.do" class="btn btn-primary btn-sm">목록</a>
	</div>
	<hr>
	<div class="well">
		<form class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-9 col-sm-off">
					<input type="text" class="form-control" name="contents" />
				</div>
				<div class="col-sm-1">
					<button type="submit" class="btn btn-primary btn-sm" id="btn-add-comment">등록</button>
				</div>
			</div>
		</form>
		<table id="table-comments" class="table table-condensed">
			<colgroup>
				<col width="">
				<col width="10%">
				<col width="5%">
				<col width="5%">
			</colgroup>
			<tbody>
			</tbody>
		</table>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	
	$.ajax({
		type:"GET",
		url:"getComments.do",
		data:{boardNo:'${board.no}'},
		dataType:'json',
		success:function(comments){
			var html = "";
			$.each(comments,function(index, comment){
			html += "<tr>";
			html += "<td>"+comment.contents+"</td>";
			html += "<td>"+comment.createdate+"</td>";
			html += "<td>"+comment.writer.fullname+"</td>";
			html += "<td><button class='btn btn-danger btn-xs' id='btn-del-comment-"+comment.no+"'>삭제</button></td>";
			html += "</tr>";
			});
			$("#table-comments tbody").html(html);
		}
	});
	
	$("#btn-add-comment").click(function(event){
		event.preventDefault();
		
		$.ajax({
			type:"POST",
			url:"addComment.do",
			data:{contents:$(":input[name=contents]").val(), boardNo:'${board.no}'},
			dataType:"json",
			success:function(comment){
				var html = "<tr>";
				html += "<td>"+comment.contents+"</td>";
				html += "<td>"+comment.createdate+"</td>";
				html += "<td>"+comment.writer.fullname+"</td>";
				html += "<td><button class='btn btn-danger btn-xs' id='btn-del-comment-"+comment.no+"'>삭제</button></td>";
				html += "</tr>";
				
				$("#table-comments tbody").append(html);
				
				$(":input[name=contents]").val("");
			}
		})
	});
	
	$("#table-comments tbody").on('click','button[id^=btn-del-comment]',function(event){
		event.preventDefault();
		var $button = $(this);
		var cNo = $button.attr("id").replace("btn-del-comment-","");
		
		$.ajax({
			type:"POST",
			url:"delComment.do",
			data:{commentNo:cNo},
			dataType:"json",
			success:function(comment){
				$button.parents("tr").remove();	
				// $button.closest("tr").remove(); 이렇게도 쓸수 있다.
			}
		});
	});
	
})
</script>
</html>