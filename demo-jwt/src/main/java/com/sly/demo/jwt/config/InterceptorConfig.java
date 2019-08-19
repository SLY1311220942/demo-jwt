package com.sly.demo.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sly.demo.jwt.interceptor.AuthenticationInterceptor;

/**
 * 拦截器配置
 * 
 * @author sly
 * @time 2019年8月19日
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private AuthenticationInterceptor authenticationInterceptor;

	/**
	 * 注册登录拦截器
	 * 
	 * @param registry
	 * @author sly
	 * @time 2018年11月25日
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
		// excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns();
	}
}
