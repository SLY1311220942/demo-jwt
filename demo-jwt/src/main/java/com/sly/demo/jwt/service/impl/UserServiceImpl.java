package com.sly.demo.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.demo.jwt.model.User;
import com.sly.demo.jwt.properties.UserProperties;
import com.sly.demo.jwt.service.UserService;

/**
 * 用户service接口实现
 * 
 * @author sly
 * @time 2019年8月19日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserProperties userProperties;

	/**
	 * 根据id查询用户
	 * 
	 * @param userId
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	@Override
	public User findUserById(String userId) {
		return userProperties.userIdMap.get(userId);
	}

	/**
	 * 根据名字查询用户
	 * 
	 * @param username
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	@Override
	public User findUserByName(String username) {
		return userProperties.userNameMap.get(username);
	}
}
