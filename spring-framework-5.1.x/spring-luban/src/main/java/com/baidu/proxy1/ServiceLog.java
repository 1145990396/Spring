package com.baidu.proxy1;

import com.baidu.services.Service;

public class ServiceLog implements Service {
	Service target;

	public ServiceLog(Service service) {
		this.target = service;
	}

	@Override
	public void query() {
		System.out.println("log");
		target.query();
	}
}
