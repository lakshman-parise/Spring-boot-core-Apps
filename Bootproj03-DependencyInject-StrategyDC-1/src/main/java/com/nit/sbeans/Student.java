package com.nit.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {

	@Autowired
	//@Qualifier("jMaterial")
	private IMaterial material; // Has-A-Property
	
	public Student() {
		System.out.println("Student: 0-param-constructor");
	}
	
	//b.method
	public void prepare(String sourcebasic, String destadvance) {
		System.out.println("Student.prepare()");
		material.write();
		System.out.println("Java Material writing start basic: "+sourcebasic);
		material.read();
		System.out.println("Java Material reading advance level: "+destadvance);
	}
}
