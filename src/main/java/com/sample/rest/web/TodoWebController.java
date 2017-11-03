package com.sample.rest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoWebController {

	@RequestMapping("/")
	public String home() {
		return "/WEB-INF/views/todo/home.jsp";
	}
}
