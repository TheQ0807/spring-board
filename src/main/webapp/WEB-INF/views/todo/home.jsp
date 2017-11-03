<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Todo</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Todo List</h1>
	<div class="text-right">
		<button id="btn-new-todo" class="btn btn-primary btn-sm">등록</button>
	</div>
	<table id="todo-table" class="table table-condensed">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
				<th></th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	<div class="modal fade" id="todo-form-modal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Todo 등록폼</h4>
				</div>
				<form>
					<input type="hidden" name="no" />
					<div class="modal-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" class="form-control" name="title">
						</div>
						<div class="form-group">
							<label>제목</label>
							<input type="date" class="form-control" name="dates">
						</div>
						<div class="form-group">
							<label>제목</label>
							<textarea rows="3" class="form-control" name="description"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary btn-sm" id="btn-add-todo">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('#todo-form-modal').on('hidden.bs.modal',function(e){
		$(":input[name=no]").val("");
		$(":input[name=title]").val("");
		$(":input[name=dates]").val("");
		$("textarea[name=description]").val("");
	});
	
	$("#todo-table tbody").on('click',"button[id^=btn-modify-todo]", function(){
		var todoNo = $(this).attr("id").replace("btn-modify-todo-","");
		
		$.getJSON("todos/"+todoNo)
		.done(function(todo){
			$(":input[name=no]").val(todo.no);
			$(":input[name=title]").val(todo.title);
			$(":input[name=dates]").val(todo.dates);
			$("textarea[name=description]").val(todo.description);
			
			$("#todo-form-modal").modal("show");
		});
	});
	
	
	$("#todo-table tbody").on("click","button[id^=btn-del-todo]",function(){
		var todoNo = $(this).attr("id").replace("btn-del-todo-","");
		var $tr = $(this).closest("tr");
		
		$.ajax({
			type:"DELETE",
			url:"todos/"+todoNo,
			dataType:"json",
			success:function(todo){
				$tr.remove();
			}
		});
	});
	
	$.ajax({
		type:"GET",
		url:"todos",
		dataType:"json",
		success:function(todos){
			var html = "";
			$.each(todos, function(index, todo){
				html += "<tr>";
				html += "<td>"+todo.no+"</td>";
				html += "<td>"+todo.title+"</td>";
				html += "<td>"+todo.dates+"</td>";
				html += "<td>";
				html += "<button class='btn btn-warning btn-xs' id='btn-modify-todo-"+todo.no+"'>수정</button> "
				html += "<button class='btn btn-danger btn-xs' id='btn-del-todo-"+todo.no+"'>삭제</button>";
				html += "</td>";
				html += "</tr>";
			});
			$("#todo-table tbody").html(html);
		}
	});
	$("#btn-new-todo").click(function(){
		$("#todo-form-modal").modal("show");
	});
	
	$("#btn-add-todo").click(function(event){
		event.preventDefault();
		var method = "POST";
		var todo = {
			title: $(":input[name=title]").val(),
			dates: $(":input[name=dates]").val(),
			description: $("textarea[name=description]").val()
				
		};
		var todoNo = $(":input[name=no]").val()
		if(todoNo){
			todo["no"] = todoNo;
			method = "PUT";
			url="todos/" + todoNo;
		}			
		$.ajax({
			type:method,
			url:url,
			contentType:"application/json",	//서버로 보내는 요청 데이터의 타입
			data: JSON.stringify(todo),		//	데이터를 json표기법의 테스트로 보낸다.
			dataType:"json",				// 서버로 받는 응답데이터의 타입
			success:function(todo){
				var html = "";
			$.each(todo,function(index, todo){
				
				html += "<tr>";
				html += "<td>"+todo.no+"</td>";
				html += "<td>"+todo.title+"</td>";
				html += "<td>"+todo.dates+"</td>";
				html += "<td>";
				html += "<button class='btn btn-warning btn-xs' id='btn-modify-todo-"+todo.no+"'>수정</button> "
				html +="<button class='btn btn-danger btn-xs' id='btn-del-todo-"+todo.no+"'>삭제</button>";
				html += "</td>";
				html += "</tr>";
				if(todoNo){
						
				} else{
					$("#todo-table tbody").append(html);				
				}
			});
			},
			complete:function(){
				$("#todo-form-modal").modal("hide");
			}
		})
	});
})
</script>
</body>
</html>