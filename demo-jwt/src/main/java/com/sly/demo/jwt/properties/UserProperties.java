package com.sly.demo.jwt.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sly.demo.jwt.model.User;

@Component
public class UserProperties {
	public Map<String, User> userNameMap = new HashMap<>(16);
	public Map<String, User> userIdMap = new HashMap<>(16);
	
	
	public UserProperties() {
		// 
		userNameMap.put("damao", new User("1", "damao", "123456"));
		userNameMap.put("ermao", new User("2", "ermao", "234567"));
		userNameMap.put("sanmao", new User("3", "sanmao", "345678"));
		userNameMap.put("simao", new User("4", "simao", "456789"));
		userNameMap.put("wumao", new User("5", "wumao", "567891"));
		userNameMap.put("liumao", new User("6", "liumao", "678912"));
		userNameMap.put("qimao", new User("7", "qimao", "789123"));
		userNameMap.put("bamao", new User("8", "bamao", "891234"));
		userNameMap.put("jiumao", new User("9", "jiumao", "912345"));
		// 
		userIdMap.put("1", new User("1", "damao", "123456"));
		userIdMap.put("2", new User("2", "ermao", "234567"));
		userIdMap.put("3", new User("3", "sanmao", "345678"));
		userIdMap.put("4", new User("4", "simao", "456789"));
		userIdMap.put("5", new User("5", "wumao", "567891"));
		userIdMap.put("6", new User("6", "liumao", "678912"));
		userIdMap.put("7", new User("7", "qimao", "789123"));
		userIdMap.put("8", new User("8", "bamao", "891234"));
		userIdMap.put("9", new User("9", "jiumao", "912345"));
	}
	
}
