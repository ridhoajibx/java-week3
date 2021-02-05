package com.glints.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinestore.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
