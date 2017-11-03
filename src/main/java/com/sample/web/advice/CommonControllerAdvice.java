package com.sample.web.advice;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.sample.exception.HTAException;
import com.sample.web.editor.DateEditor;

@ControllerAdvice
public class CommonControllerAdvice {

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());// WebDataBinder 가  바꿔준다아아아아아아아아 
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error/unknown_error";
	}
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e) {
		e.printStackTrace();
		return "error/db_error";
	}
	@ExceptionHandler(HTAException.class)
	public String htaExceptionHandler(HTAException e) {
		return "error/hta_error";
	}
}
