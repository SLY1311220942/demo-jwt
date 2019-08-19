package com.sly.demo.jwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sly.demo.jwt.model.User;
import com.sly.demo.jwt.service.UserService;
import com.sly.demo.jwt.utils.JWTUtils;

/**
 * 登录controller
 * 
 * @author sly
 * @time 2019年8月19日
 */
@RestController
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public Object login(HttpServletRequest request, HttpServletResponse response, User user) {
		Map<String, Object> result = new HashMap<>(16);
		User existUser = userService.findUserByName(user.getUsername());
		if(existUser == null || !existUser.getPassword().equals(user.getPassword())) {
			result.put("status", 400);
			result.put("message", "用户名或密码错误！");
		} else {
			String token = JWTUtils.getToken(existUser);
			result.put("status", 200);
			result.put("message", "登录成功！");
			result.put("token", token);
		}
		return result;
	}
}
