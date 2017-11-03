package com.sample.user.mappers;

import com.sample.user.vo.User;

public interface UserMapper {

	User getUserById(String userId);
	void addUser(User user);
	void updateUser(User user);
}
