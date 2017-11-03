package com.sample.web.intercepter;

import java.lang.ProcessBuilder.Redirect;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sample.user.vo.User;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private Set<String> urlSet;
	public void setUrlSet(Set<String> urlSet) {
		this.urlSet = urlSet;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestURI = request.getRequestURI();
		if(urlSet.contains(requestURI)) {
			return true;
		}
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("/user/login.do?error=deny");
		}
		
		User user =  (User) session.getAttribute("LOGIN_USER");
		if(user == null) {
			response.sendRedirect("/user/login.do?error=deny");
			return false;
		}else {
			return true;
		}
	}
	
}
