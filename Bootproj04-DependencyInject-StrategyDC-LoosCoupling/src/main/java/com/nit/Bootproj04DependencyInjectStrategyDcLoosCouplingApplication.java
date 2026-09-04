package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nit.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("classpath:com/nit/Config/applicationContext.xml")
public class Bootproj04DependencyInjectStrategyDcLoosCouplingApplication {

	public static void main(String[] args) {
		//get IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(Bootproj04DependencyInjectStrategyDcLoosCouplingApplication.class, args);
	    
		//get target spring bean class obj ref
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
		
		//b.method
		vehicle.journey("Bengaluru", "New Delhi");
		
		//close IOC container
		ctx.close();
	}

}
