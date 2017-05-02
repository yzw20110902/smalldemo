package yzwTax.itcast.test.service.impl;

import org.springframework.stereotype.Service;

import yzwTax.itcast.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("hello spring .......");

	}

}
