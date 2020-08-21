package com.luban.services;

import org.springframework.stereotype.Service;


public class IndexService {
	public IndexService(BeanService service) {
		System.out.println(service);
	}

	public void query() {
		System.out.println("logic");
	}
}
