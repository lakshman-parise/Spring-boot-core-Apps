package com.nit.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	@Autowired
	//@Qualifier("engine.id") --> invalid
	//@Qualifier("@Value("${engine.id}")) --> invalid
	@Qualifier("engg")
	private IEngine engine; //Has-A-property
	
	public Vehicle() {
		System.out.println("Vehicle: 0-param constructor");
	}
	
	//b.method
	public void journey(String sourceplace, String destplace) {
		System.out.println("Vehicle.journey()");
		engine.start();
		System.out.println("Vehicle Start: "+sourceplace);
		engine.stop();
		System.out.println("Vehicle stop: "+destplace);
	}
}
