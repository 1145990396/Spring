package com.luban.beanDefinition;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotVeryUsefulAspect {
	@Pointcut("execution(public * com.luban.beanDefinition.*.*(..))")
	private void pointCutExecutionAny(){}

	@Pointcut("args(java.lang.String)")
	private void pointCutExecutionArgs(){}

	@Pointcut("within(com.luban.beanDefinition.*)")
	private void pointCutWithin(){}

	@Pointcut("this(com.luban.beanDefinition.OrderService)")
	private void pointCutThis(){}

	@Pointcut("@within(com.luban.beanDefinition.Luban)")
	private void pointCutAnnoWithin(){}


	@Before("pointCutExecutionAny()")
	public void doAccessCheck() {
		System.out.println("tx-----------");
	}
}
