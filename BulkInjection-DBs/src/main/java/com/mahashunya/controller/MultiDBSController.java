package com.mahashunya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahashunya.model.custm.Customer;
import com.mahashunya.model.prod.Product;
import com.mahashunya.repo.custm.ICustomerRepository;
import com.mahashunya.repo.prod.IProductRepsitory;

@RestController
public class MultiDBSController {

	@Autowired
	private IProductRepsitory prodRepo;
	@Autowired
	private ICustomerRepository custmRepo;
	
	@GetMapping("/allProds")
	public List<Product> getAllProds(){
		return prodRepo.findAll();
	}
	
	@GetMapping("/allCutsms")
	public List<Customer> getAllCutms(){
		return custmRepo.findAll();
	}
 }
