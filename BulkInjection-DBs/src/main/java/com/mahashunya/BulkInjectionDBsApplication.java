package com.mahashunya;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mahashunya.model.custm.Customer;
import com.mahashunya.model.prod.Product;
import com.mahashunya.repo.custm.ICustomerRepository;
import com.mahashunya.repo.prod.IProductRepsitory;

@SpringBootApplication
public class BulkInjectionDBsApplication  implements CommandLineRunner{

	@Autowired
	private IProductRepsitory prodRepo;
	@Autowired
	private ICustomerRepository custmRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BulkInjectionDBsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		prodRepo.saveAll(
                               Arrays.asList(
                                            new Product(101, "mobile",15000.0),
                                            new Product(102, "washingMachine",26000.0)));
		
		custmRepo.saveAll(
                                Arrays.asList(  
                                		     new Customer(10,"lakshman","laks@gmail.com"),
                                		     new Customer(11,"ram","ram@gmail.com")));
	}

}
