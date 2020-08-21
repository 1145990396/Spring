package com.baidu.proxy;

import com.baidu.services.IndexService;

public class IndexServiceProxyPower extends IndexService {
	@Override
	public void query() {
		System.out.println("start power");
		super.query();
	}
}
