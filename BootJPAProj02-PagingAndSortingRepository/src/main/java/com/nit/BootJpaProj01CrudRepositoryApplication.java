package com.nit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

@SpringBootApplication
public class BootJpaProj01CrudRepositoryApplication {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//get IOC container
		SpringApplication.run(BootJpaProj01CrudRepositoryApplication.class, args);
	}
        
}
