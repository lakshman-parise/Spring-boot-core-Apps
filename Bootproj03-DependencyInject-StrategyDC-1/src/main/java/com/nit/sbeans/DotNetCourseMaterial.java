package com.nit.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dotNetMaterial")
public class DotNetCourseMaterial implements IMaterial {

	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMateria: 0-param constructor");
	}
	@Override
	public void write() {
		System.out.println("DotNetCourseMaterial.write()");

	}

	@Override
	public void read() {
		System.out.println("DotNetCourseMaterial.read()");
	}

}
