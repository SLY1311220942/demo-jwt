package com.sly.demo.jwt.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sly.demo.jwt.annotation.AuthPermission;
import com.sly.demo.jwt.model.User;
import com.sly.demo.jwt.service.UserService;

/**
 * 授权拦截器
 * 
 * @author sly
 * @time 2019年8月19日
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年8月19日
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 从 http 请求头中取出 token
		String token = request.getHeader("token");
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		response.setCharacterEncoding("UTF-8");
		// 检查是否有AuthPermission注释，无则跳过认证
		if (method.isAnnotationPresent(AuthPermission.class)) {
			AuthPermission authPermission = method.getAnnotation(AuthPermission.class);
			if (!authPermission.required()) {
				// 不需要验证
				return true;
			}
			
			// 验证
			Map<String, Object> result = new HashMap<>(16);
			String userId = "";
			if(StringUtils.isBlank(token)) {
				result.put("status", 300);
				result.put("message", "无token");
				response.getWriter().write(JSON.toJSONString(result));
				return false;
			} 
			
			try {
				// 验证用户
				userId = JWT.decode(token).getAudience().get(0);
				User user = userService.findUserById(userId);
				if(user == null) {
					result.put("status", 400);
					result.put("message", "用户不存在！");
					response.getWriter().write(JSON.toJSONString(result));
					return false;
				}
           
            	// 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            	jwtVerifier.verify(token);
			} catch (JWTVerificationException e) {
				LOGGER.error(ExceptionUtils.getStackTrace(e));
				result.put("status", 400);
				result.put("message", "验证token失败！");
				result.put("info", ExceptionUtils.getStackTrace(e));
				response.getWriter().write(JSON.toJSONString(result));
				return false;
			} catch (Exception e) {
				LOGGER.error(ExceptionUtils.getStackTrace(e));
				result.put("status", 500);
				result.put("message", "系统错误！");
				result.put("info", ExceptionUtils.getStackTrace(e));
				response.getWriter().write(JSON.toJSONString(result));
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param modelAndView
	 * @throws Exception
	 * @author sly
	 * @time 2019年8月19日
	 */
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param e
	 * @throws Exception
	 * @author sly
	 * @time 2019年8月19日
	 */
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
