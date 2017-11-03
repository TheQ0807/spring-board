package com.sample.rest.service;

import java.util.List;

import com.sample.rest.vo.Todo;

public interface TodoService {

	void addTodo(Todo todo);
	Todo getTodo(int no);
	List<Todo> getTodos();
	void updateTodo(Todo todo);
	void deleteTodo(int no);
}
