package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("cEngine")
//@Profile("cEngine")
public class CNGEngine implements IEngine {

	public CNGEngine() {
		System.out.println("CNGEngine: 0-param-constructor");
	}
	@Override
	public void start() {
		System.out.println("CNGEngine.start()");
	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop()");

	}

}
