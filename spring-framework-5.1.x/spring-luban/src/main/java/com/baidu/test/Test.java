package com.baidu.test;


import com.baidu.app.Appconfig;
import com.baidu.batis.LubanProxy;

import com.baidu.services.UserDao;
import com.baidu.services.ZLService;
import com.baidu.target.UserDaoImpl;
import com.baidu.target.ZLServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;


public class Test {

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		ac.register(Appconfig.class);
		ac.refresh();
	}


}
