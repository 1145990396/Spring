package com.baidu.proxy;

import com.baidu.services.IndexService;

public class IndexServiceProxyLogPower extends IndexServiceProxyLog {
	@Override
	public void query() {
		System.out.println("start power");
		super.query();
	}
}
