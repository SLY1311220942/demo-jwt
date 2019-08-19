package com.sly.demo.jwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sly.demo.jwt.annotation.AuthPermission;

@RestController
@RequestMapping("/business")
public class BusinessController {

	/**
	 * 订单服务
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	@AuthPermission
	@RequestMapping("/order")
	public Object order(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "订单服务调用成功！");
		return result;
	}
	
	
	/**
	 * 商品服务
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author sly
	 * @time 2019年8月19日
	 */
	@RequestMapping("/goods")
	public Object goods(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "商品服务调用成功！");
		return result;
	}
}
