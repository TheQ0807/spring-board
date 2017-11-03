package com.sample.rest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.service.TodoService;
import com.sample.rest.vo.Todo;

@RestController
@RequestMapping
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}
	
	@GetMapping("/todos/{no}")
	public Todo getTodo(@PathVariable("no") int no) {
		return todoService.getTodo(no);
	}
	
	@PostMapping("/todos")
	public List<Todo> addTodo(@RequestBody Todo todo) { // 리퀘스트 바디는 요청메세지형식이 xml, json 일때 그것을 적절하게 해석해서 요청메세지 바디에 넣어준다.
		todoService.addTodo(todo);
		return todoService.getTodos();
	}
	
	@DeleteMapping("todos/{no}")
	public Todo deleteTodo(@PathVariable("no") int no) {
		Todo todo = todoService.getTodo(no);
		todoService.deleteTodo(no);
		return todo;
	}
	
	public List<Todo> updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todoService.getTodos();
	}
}
