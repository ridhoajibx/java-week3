package com.glints.onlinestore.service;

import java.util.List;

import com.glints.onlinestore.exception.BadRequestException;
import com.glints.onlinestore.model.Product;
import com.glints.onlinestore.payload.ProductPayload;

public interface ProductService {
	public List<Product> read();
	public Product create(ProductPayload productPayload);
	public Product update(Integer id, ProductPayload productPayload) throws BadRequestException;
	public String delete(Integer id);
	public Product readById(Integer id);
}
