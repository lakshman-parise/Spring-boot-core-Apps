package com.nit.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("phpMaterial")
//The @Profile annotation in Spring is used to conditionally enable beans based on the active profile. It allows you to define different bean implementations or configurations for
//different environments (like php, java, dotNet, etc.) without changing the application code.
public class PhpCourseMaterial implements IMaterial {

	public PhpCourseMaterial() {
		System.out.println("PhpCourseMateria: 0-param constructor");
	}
	@Override
	public void write() {
		System.out.println("PhpCourseMaterial.write()");

	}

	@Override
	public void read() {
		System.out.println("PhpCourseMaterial.read()");
	}

}
