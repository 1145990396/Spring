package com.luban.test;

import com.luban.app.Appconfig;
import com.luban.batis.LubanFactory;
import com.luban.beanDefinition.I;
import com.luban.beanDefinition.OrderService;
import com.luban.beanDefinition.UserService;
import com.luban.services.UserDao;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;


public class Test {

	public static void main(String[] args)  {
		AnnotationConfigApplicationContext ac =
				new AnnotationConfigApplicationContext(Appconfig.class);
//		I bean = ac.getBean(I.class);
//		System.out.println(bean);
		ac.getBean(OrderService.class);
//		ac.getBean(OrderService.class);
	}
}
