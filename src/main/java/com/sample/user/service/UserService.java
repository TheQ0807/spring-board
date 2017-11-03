package com.sample.user.service;

import com.sample.user.vo.User;

public interface UserService {

	void addNewUser(User user);
	User getUserDetail(String userId);
}
