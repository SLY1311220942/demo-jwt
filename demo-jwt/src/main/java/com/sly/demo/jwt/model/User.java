package com.sly.demo.jwt.model;

import java.io.Serializable;

/**
 * 用户model类
 * 
 * @author sly
 * @time 2019年8月19日
 */
public class User implements Serializable {

	private static final long serialVersionUID = 6996462094283965239L;

	/** 用户id */
	private String id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;

	public User() {
	}

	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
