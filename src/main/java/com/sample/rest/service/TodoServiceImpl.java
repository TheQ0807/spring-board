package com.sample.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rest.mappers.TodoMapper;
import com.sample.rest.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoMapper todoMapper;
	
	@Override
	public void addTodo(Todo todo) {
		int seq = todoMapper.getSeq();
		todo.setNo(seq);
		todoMapper.addTodo(todo);
	}
	@Override
	public Todo getTodo(int no) {
		return todoMapper.getTodo(no);
	}
	@Override
	public List<Todo> getTodos() {
		return todoMapper.getTodos();
	}
	@Override
	public void updateTodo(Todo todo) {
		todoMapper.updateTodo(todo);
	}
	@Override
	public void deleteTodo(int no) {
		todoMapper.deleteTodo(no);
	}
}
