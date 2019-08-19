package com.sly.demo.jwt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证授权注解
 * 
 * @author sly
 * @time 2019年8月19日
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPermission {
	boolean required() default true;
}
