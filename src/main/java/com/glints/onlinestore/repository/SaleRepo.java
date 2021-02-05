package com.glints.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinestore.model.Sale;

public interface SaleRepo extends JpaRepository<Sale, Integer> {

}
