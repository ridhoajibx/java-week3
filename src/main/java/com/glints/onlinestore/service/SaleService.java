package com.glints.onlinestore.service;

import java.util.List;

import com.glints.onlinestore.model.Sale;
import com.glints.onlinestore.payload.SalePayload;

public interface SaleService {
	public List<Sale> read();
	public Sale create(SalePayload salePayload);
	public Sale update(Integer id, SalePayload salePayload);
	public String delete(Integer id);
	public Sale readById(Integer id);
}
