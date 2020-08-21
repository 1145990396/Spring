package com.luban.beanDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService {
//	@PostConstruct
//	public void init() {
//		System.out.println("init");
//	}

//	public void testApo() {
//		System.out.println("testApo1----UserService");
//	}

	@Autowired
	OrderService orderService;

	public UserService() {
		//System.out.println("start user");
	}
}
