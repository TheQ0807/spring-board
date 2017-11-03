package com.sample.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.user.service.UserService;
import com.sample.user.vo.CheckResult;
import com.sample.user.vo.User;

@Controller
public class UserAjaxController {

	@Autowired
	UserService userService;
	
	// ajax로 회원가입 가능한 아이디인지여부를 바로 출력하기 위한 것
	@RequestMapping("/user/idcheck.do")
	public @ResponseBody CheckResult idcheck(@RequestParam("id") String userid) {
		
		// ResponseBody 응답 바디에 객체를 넣어주겠다라는 어노테이션이다.
		// 젝슨데이터바인드 라이브러리를 포함시키면 xml이나 json파일로 변환시켜서 응답바디에 넣어준다.
		CheckResult result = new CheckResult();
		
		User user = userService.getUserDetail(userid);
		if(user != null) {
			result.setUsed(true);
		}
		return result;
	}
	
}
