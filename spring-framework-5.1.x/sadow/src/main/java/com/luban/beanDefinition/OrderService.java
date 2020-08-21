package com.luban.beanDefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class OrderService  {

//	@Autowired
//	UserService userService;

	public OrderService() {
		System.out.println("start default");
	}
//
//

	public OrderService(UserService userService) {
		System.out.println("user");
	}

	public OrderService(CglibUtil cglibUtil) {
		System.out.println("cglibUtil");
	}


//	public OrderService(UserService userService, CglibUtil cglibUtil) {
//		System.out.println("CglibUtil user");
//	}


}
