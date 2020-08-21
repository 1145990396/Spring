package com.baidu.proxy;

public class IndexServiceProxyPowerLog extends IndexServiceProxyPower {
	@Override
	public void query() {
		System.out.println("start log");
		super.query();
	}
}
