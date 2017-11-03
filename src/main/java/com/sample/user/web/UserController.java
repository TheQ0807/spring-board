package com.sample.user.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.user.service.UserService;
import com.sample.user.vo.User;
import com.sample.user.web.form.UserForm;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/form.do")
	public String form(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "user/form";
	}
	
	@RequestMapping("/add.do")
	public String register(@Valid UserForm userForm, BindingResult errors) {
		
		if(errors.hasErrors()) {
			System.out.println("입력값이 유효하지 않습니다.");
			return "user/form";
		}
		if(userService.getUserDetail(userForm.getId()) != null) {
			errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");
			return "user/form";
		}
		
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		
		// 패스워드를 암호하하는코드 다이제스트유틸
		String encryptPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(encryptPassword);
		
		userService.addNewUser(user);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginform() {
		
		return "user/loginform";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginprocess(@RequestParam("userid") String id,
			@RequestParam("userpwd") String password,
			HttpSession session) {
		
		User user = userService.getUserDetail(id);
		if(user == null) {
			return "redirect:/user/login.do?error=fail";
		}
		String encryptPassword = DigestUtils.md5DigestAsHex(password.getBytes());
		if(!user.getPassword().equals(encryptPassword)) {
			return "redirect:/user/login.do?error=fail";
		}
		session.setAttribute("LOGIN_USER", user);
		
		
		return "redirect:/home.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/home.do";
	}
}
