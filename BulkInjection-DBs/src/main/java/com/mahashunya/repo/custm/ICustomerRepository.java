package com.mahashunya.repo.custm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahashunya.model.custm.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
