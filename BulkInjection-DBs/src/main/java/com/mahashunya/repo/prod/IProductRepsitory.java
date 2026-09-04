package com.mahashunya.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahashunya.model.prod.Product;

public interface IProductRepsitory extends JpaRepository<Product, Integer> {

}
