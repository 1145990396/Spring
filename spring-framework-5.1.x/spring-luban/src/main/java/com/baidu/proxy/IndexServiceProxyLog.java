package com.baidu.proxy;

import com.baidu.services.IndexService;

public class IndexServiceProxyLog extends IndexService {
	@Override
	public void query() {
		System.out.println("start log");
		super.query();
	}
}
