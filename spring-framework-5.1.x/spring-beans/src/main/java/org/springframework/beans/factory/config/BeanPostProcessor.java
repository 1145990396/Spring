/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 *
 * <p>ApplicationContexts can autodetect BeanPostProcessor beans in their
 * bean definitions and apply them to any beans subsequently created.
 * Plain bean factories allow for programmatic registration of post-processors,
 * applying to all beans created through this factory.
 *
 * <p>Typically, post-processors that populate beans via marker interfaces
 * or the like will implement {@link #postProcessBeforeInitialization},
 * while post-processors that wrap beans with proxies will normally
 * implement {@link #postProcessAfterInitialization}.
 *
 * @author Juergen Hoeller
 * @since 10.10.2003
 * @see InstantiationAwareBeanPostProcessor
 * @see DestructionAwareBeanPostProcessor
 * @see ConfigurableBeanFactory#addBeanPostProcessor
 * @see BeanFactoryPostProcessor
 */
public interface BeanPostProcessor {

	/**
	 * 在任何bean之前，将此BeanPostProcessor应用到给定的新bean实例
	 * 初始化回调(如InitializingBean的{@code afterPropertiesSet})
	 * 或自定义的init方法)。bean已经填充了属性值。
	 * 返回的bean实例可能是原始bean的包装器。
	 * 默认实现按原样返回给定的{@code bean}。
	 * @param bean 新 bean实例
	 * @param beanName bean的名字
	 * @返回要使用的bean实例，原始的或包装好的bean实例;
	 * 如果{@code null}，则不会调用后续的BeanPostProcessors
	 * @throws org.springframework.beans。BeansException在错误的情况下
	 * @see org.springframework.beans.factory.InitializingBean # afterPropertiesSet
	 * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 */
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * 在任何bean之后，将此BeanPostProcessor应用到给定的新bean实例<i></i>
	 * <i>初始化回调(如InitializingBean的{@code afterPropertiesSet})</i>
	 * <i>或者自定义的init方法)。bean已经填充了属性值。</i>
	 * <i>返回的bean实例可能是原始bean的包装器。</i>
	 * <i></i>
	 * <i>对于FactoryBean，这个回调将同时为FactoryBean调用</i>
	 * <i>实例和FactoryBean创建的对象(从Spring 2.0开始)。的</i>
	 * <i>后处理器可以决定是应用到FactoryBean还是已创建的</i>
	 * <i>对象或通过相应的{@code bean instanceof FactoryBean}检查两者。</i>
	 * <i></i>
	 * <i>此回调也将在a触发短路后被调用</i>
	 * <i>{@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation}与所有其他BeanPostProcessor回调相比。</i>
	 * <i></i>
	 * <i>默认实现按原样返回给定的{@code bean}。</i>
	 * <i>@param bean新bean实例</i>
	 * <i>@param beanName豆子的名字</i>
	 * <i>@返回要使用的bean实例，原始的或封装的bean实例;</i>
	 * <i>如果{@code null}，则不会调用后续的beanpostprocessor</i>
	 * <i>@throws org.springframework.beans。BeansException在错误的情况下</i>
	 * <i>@see org.springframework.beans.factory.InitializingBean # afterPropertiesSet</i>
	 * <i>@see org.springframework.beans.factory.FactoryBean</i>
	 * Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
	 * instance and the objects created by the FactoryBean (as of Spring 2.0). The
	 * post-processor can decide whether to apply to either the FactoryBean or created
	 * objects or both through corresponding {@code bean instanceof FactoryBean} checks.
	 * <p>This callback will also be invoked after a short-circuiting triggered by a
	 * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
	 * in contrast to all other BeanPostProcessor callbacks.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 * @see org.springframework.beans.factory.FactoryBean
	 */
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
