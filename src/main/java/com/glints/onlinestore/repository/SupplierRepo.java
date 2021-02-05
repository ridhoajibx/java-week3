package com.glints.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinestore.model.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}
