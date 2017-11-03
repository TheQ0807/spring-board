package com.sample.rest.mappers;

import java.util.List;

import com.sample.rest.vo.Todo;

public interface TodoMapper {

	int getSeq();
	List<Todo> getTodos();
	Todo getTodo(int no);
	void addTodo(Todo todo);
	void updateTodo(Todo todo);
	void deleteTodo(int no);
}
