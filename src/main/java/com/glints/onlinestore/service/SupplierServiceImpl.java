package com.glints.onlinestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.onlinestore.model.Supplier;
import com.glints.onlinestore.payload.SupplierPayload;
import com.glints.onlinestore.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepo supplierRepo;

	@Override
	public List<Supplier> read() {
		List<Supplier> suppliers = supplierRepo.findAll();
		return suppliers;
	}

	@Override
	public Supplier create(SupplierPayload supplierPayload) {
		Supplier supplier = new Supplier(supplierPayload.getName(),
								supplierPayload.getAddress(),
								supplierPayload.getContact()
							);
		supplier = supplierRepo.save(supplier);
		return supplier;
	}

	@Override
	public Supplier update(Integer id, SupplierPayload supplierPayload) {
		Supplier supplier = supplierRepo.findById(id).orElse(null);
		supplier.setName(supplierPayload.getName());
		supplier.setAddress(supplierPayload.getAddress());
		supplier.setContact(supplierPayload.getContact());
		supplier.setUpdatedTime(new Date());
		supplier = supplierRepo.save(supplier);
		return supplier;
	}

	@Override
	public String delete(Integer id) {
		supplierRepo.deleteById(id);
		return "Supplier with id: " + id + " has been deleted!";
	}

	@Override
	public Supplier readById(Integer id) {
		Supplier supplier = supplierRepo.findById(id).orElse(null);
		return supplier;
	}	
	
}
