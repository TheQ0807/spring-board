package com.sample.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.exception.AlreadyExistUserException;
import com.sample.user.mappers.UserMapper;
import com.sample.user.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void addNewUser(User user) {
		
		 if(userMapper.getUserById(user.getId()) != null) {
			throw new AlreadyExistUserException("["+user.getId()+"] 은/는 사용중인 아이디입니다.");
		}
		
		userMapper.addUser(user);
	}
	
	@Override
	public User getUserDetail(String userId) {
		return userMapper.getUserById(userId);
	}
	
}
