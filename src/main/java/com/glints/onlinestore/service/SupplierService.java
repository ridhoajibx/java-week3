package com.glints.onlinestore.service;

import java.util.List;

import com.glints.onlinestore.model.Supplier;
import com.glints.onlinestore.payload.SupplierPayload;

public interface SupplierService {
	public List<Supplier> read();
	public Supplier create(SupplierPayload supplierPayload);
	public Supplier update(Integer id, SupplierPayload supplierPayload);
	public String delete(Integer id);
	public Supplier readById(Integer id);
}
