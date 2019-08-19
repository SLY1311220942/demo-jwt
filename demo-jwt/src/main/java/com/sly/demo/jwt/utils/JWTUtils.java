package com.sly.demo.jwt.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sly.demo.jwt.model.User;

/**
 * jwt工具类
 * 
 * @author sly
 * @time 2019年8月19日
 */
public class JWTUtils {

	/**
	 * 根据用户生成token
	 * 
	 * @param user
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	public static String getToken(User user) {
		String token = "";
		token = JWT.create().withAudience(user.getId()).withExpiresAt(new Date(System.currentTimeMillis() + (30 * 60 * 1000))).sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}
}
