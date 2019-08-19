package com.sly.demo.jwt.service;

import com.sly.demo.jwt.model.User;

/**
 * 用户service接口
 * 
 * @author sly
 * @time 2019年8月19日
 */
public interface UserService {

	/**
	 * 根据id查询用户
	 * 
	 * @param userId
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	User findUserById(String userId);

	/**
	 * 根据名字查询用户
	 * 
	 * @param username
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	User findUserByName(String username);
}
