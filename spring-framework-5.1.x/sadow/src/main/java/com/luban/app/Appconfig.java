package com.luban.app;

import com.luban.beanDefinition.CustomAopBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan("com.luban.beanDefinition")
@EnableAspectJAutoProxy
//@Import(CustomAopBeanPostProcessor.class)
//@ImportResource("classpath:spring.xml")
public class Appconfig {



//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		return sqlSessionFactoryBean;
//	}
//
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://47.94.158.155:3306/test");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("aq1sw2de");
//		return driverManagerDataSource;
//	}

//	@Bean
//	public TDao tDao(){
//		Class<?>[] interfaces = new Class[]{TDao.class};
//		TDao tDao = (TDao) Proxy.newProxyInstance(BatisUtil.class.getClassLoader(),interfaces,new LubanInvocationHandler());
//		return tDao;
//	}





}
