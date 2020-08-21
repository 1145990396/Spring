/*
 * Copyright 2002-2018 the original author or authors.
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

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.lang.Nullable;

/**
 * BeanDefinition 描述一个bean实例，该实例具有属性值，
 * 构造函数参数值，以及进一步提供的信息具体的实现
 *
 * <p>这只是一个最小的接口:主要目的是允许
 * {@link BeanFactoryPostProcessor} 如 {@link PropertyPlaceholderConfigurer}
 * 内省和修改属性值和其他bean元数据。
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 19.03.2004
 * @see ConfigurableListableBeanFactory#getBeanDefinition
 * @see org.springframework.beans.factory.support.RootBeanDefinition
 * @see org.springframework.beans.factory.support.ChildBeanDefinition
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * 标准单例范围的范围标识符:"singleton".
	 * <p>注意，扩展的bean工厂可能支持进一步的作用域。
	 * @see #setScope
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	/**
	 * 标准原型范围标识符:“prototype”
	 * <p>注意，扩展的bean工厂可能支持进一步的作用域。
	 * @see #setScope
	 */
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;


	/**
	 * 表示{@code BeanDefinition}是主要部分的角色提示
	 * 的应用程序。通常对应于用户定义的bean
	 */
	int ROLE_APPLICATION = 0;

	/**
	 * 表示{@code BeanDefinition}是支持的角色提示
	 * 某些较大配置的一部分，通常是外部配置
	 * {@link org.springframework.beans.factory.parsing.ComponentDefinition}.
	 * {@code SUPPORT} bean被认为非常重要，值得注意
	 * 当更仔细地观察某一特定事物时
	 * {@link org.springframework.beans.factory.parsing.ComponentDefinition},
	 * 但在查看应用程序的总体配置时就不是这样了。
	 */
	int ROLE_SUPPORT = 1;

	/**
	 *角色提示，指示{@code BeanDefinition}正在提供
	 *完全是后台角色，与最终用户无关。这个提示是
	 *在注册完全属于内部工作的bean时使用
	 *一个{@link org.springframework.beans.factory.parsing.ComponentDefinition},
	 */
	int ROLE_INFRASTRUCTURE = 2;


	// Modifiable attributes

	/**
	 * 设置这个bean定义的父定义的名称(如果有的话)。
	 */
	void setParentName(@Nullable String parentName);

	/**
	 * 返回这个bean定义的父定义的名称(如果有的话)。
	 */
	@Nullable
	String getParentName();

	/**
	 * 指定这个bean定义的bean类名.
	 * <p>可以在bean工厂后处理期间修改类名,
	 * 通常使用解析后的类名变体替换原始类名.
	 * @see #setParentName
	 * @see #setFactoryBeanName
	 * @see #setFactoryMethodName
	 */
	void setBeanClassName(@Nullable String beanClassName);

	/**
	 * 返回此bean定义的当前bean类名.
	 * <p>注意，这不必是在运行时使用的实际类名
	 * 子定义覆盖/继承其父类名的情况。
	 * 而且，这可能只是工厂方法被调用的类，也可能是这样
	 * 即使在调用方法的工厂bean引用时，也要为空。
	 * 因此，do <i>not</i>认为这是在运行时确定的bean类型，但是
	 * 而只是在单个bean定义级别上使用它进行解析
	 * @see #getParentName()
	 * @see #getFactoryBeanName()
	 * @see #getFactoryMethodName()
	 */
	@Nullable
	String getBeanClassName();

	/**
	 * 覆盖此bean的目标范围，指定一个新的范围名称.
	 * @see #SCOPE_SINGLETON
	 * @see #SCOPE_PROTOTYPE
	 */
	void setScope(@Nullable String scope);

	/**
	 * 返回此bean的当前目标范围的名称,
	 * 或{@code null}(如果还不知道).
	 */
	@Nullable
	String getScope();

	/**
	 * 设置是否延迟初始化这个bean。
	 * <p>I如果{@code false}， bean将在启动时被实例化
	 * 执行单例急切初始化的工厂.
	 */
	void setLazyInit(boolean lazyInit);

	/**
	 *返回这个bean是否应该延迟初始化，即不
	 *在启动时急于实例化。只适用于单例bean。
	 */
	boolean isLazyInit();

	/**
	 * 设置这个bean所依赖的被初始化的bean的名称。
	 * bean工厂将保证这些bean首先得到初始化。
	 */
	void setDependsOn(@Nullable String... dependsOn);

	/**
	 * 返回此bean所依赖的bean名称.
	 */
	@Nullable
	String[] getDependsOn();

	/**
	 * 设置这个bean是否可以自动加载到其他bean中。
	 * <p>注意，这个标志被设计为只影响基于类型的自动装配。
	 * 它不影响按名称的显式引用，甚至可以解析名称
	 * 如果指定的bean没有标记为自动装配候选对象,
	 * 因此，如果名称匹配，按名称自动装配仍然会注入一个bean.
	 */
	void setAutowireCandidate(boolean autowireCandidate);

	/**
	 * 返回这个bean是否是自动加载到其他bean中的候选bean.
	 */
	boolean isAutowireCandidate();

	/**
	 * 设置此bean是否为主要自动装配候选对象.
	 * <p>如果该值恰好是{@code true}，用于多个bean中的一个
	 * 匹配候选人，它将成为决定胜负的关键因素.
	 */
	void setPrimary(boolean primary);

	/**
	 * 返回此bean是否是主要自动装配的候选对象.
	 */
	boolean isPrimary();

	/**
	 * Specify the factory bean to use, if any.
	 * This the name of the bean to call the specified factory method on.
	 * @see #setFactoryMethodName
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);

	/**
	 * Return the factory bean name, if any.
	 */
	@Nullable
	String getFactoryBeanName();

	/**
	 * Specify a factory method, if any. This method will be invoked with
	 * constructor arguments, or with no arguments if none are specified.
	 * The method will be invoked on the specified factory bean, if any,
	 * or otherwise as a static method on the local bean class.
	 * @see #setFactoryBeanName
	 * @see #setBeanClassName
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);

	/**
	 * 返回工厂方法(如果有的话).
	 */
	@Nullable
	String getFactoryMethodName();

	/**
	 * Return the constructor argument values for this bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the ConstructorArgumentValues object (never {@code null})
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * Return if there are constructor argument values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * Return the property values to be applied to a new instance of the bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the MutablePropertyValues object (never {@code null})
	 */
	MutablePropertyValues getPropertyValues();

	/**
	 * Return if there are property values values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}

	/**
	 * 设置初始化器方法的名称.
	 * @since 5.1
	 */
	void setInitMethodName(@Nullable String initMethodName);

	/**
	 * 返回初始化器方法的名称.
	 * @since 5.1
	 */
	@Nullable
	String getInitMethodName();

	/**
	 * 设置销毁方法的名称.
	 * @since 5.1
	 */
	void setDestroyMethodName(@Nullable String destroyMethodName);

	/**
	 * 返回销毁方法的名称.
	 * @since 5.1
	 */
	@Nullable
	String getDestroyMethodName();

	/**
	 * Set the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @since 5.1
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	void setRole(int role);

	/**
	 * Get the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	int getRole();

	/**
	 * Set a human-readable description of this bean definition.
	 * @since 5.1
	 */
	void setDescription(@Nullable String description);

	/**
	 * 返回这个bean定义的人类可读的描述
	 */
	@Nullable
	String getDescription();


	// Read-only attributes

	/**
	 * 返回是否 <b>Singleton</b>，带有一个共享实例
	 * 回复所有来电.
	 * @see #SCOPE_SINGLETON
	 */
	boolean isSingleton();

	/**
	 * 返回是否是 <b>Prototype</b>，带有一个独立的实例
	 * 为每个调用返回
	 * @since 3.0
	 * @see #SCOPE_PROTOTYPE
	 */
	boolean isPrototype();

	/**
	 * 返回这个bean是否“抽象”，也就是说，是否意味着不需要实例化.
	 */
	boolean isAbstract();

	/**
	 * 返回这个bean定义的资源的描述
	 * 来自(为了在出现错误时显示上下文)。
	 */
	@Nullable
	String getResourceDescription();

	/**
	 *返回原始BeanDefinition，如果没有，则返回{@code null}。
	 *允许检索修饰bean定义(如果有的话)。
	 *注意，此方法返回直接的发起者。遍历的
	 *查找由用户定义的原始BeanDefinition的发起人链。
	 */
	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
