package com.baidu.proxy1;

import com.baidu.services.Service;

public class ServiceTx implements Service {

	public ServiceTx(Service service) {
		this.target = service;
	}
	Service target;
	@Override
	public void query() {
		System.out.println("tx");
		target.query();
	}
}
