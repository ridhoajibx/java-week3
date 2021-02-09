package com.glints.onlinestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.onlinestore.exception.BadRequestException;
import com.glints.onlinestore.model.Product;
import com.glints.onlinestore.model.Supplier;
import com.glints.onlinestore.payload.ProductPayload;
import com.glints.onlinestore.repository.ProductRepo;
import com.glints.onlinestore.repository.SupplierRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	SupplierRepo supplierRepo;

	@Override
	public List<Product> read() {
		List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public Product create(ProductPayload productPayload) {
		Supplier supplier = supplierRepo.findById(productPayload.getSupplierId()).orElse(null);
		Product product = new Product(productPayload.getProductName(),
								productPayload.getPrice(),
								productPayload.getQuantity(),
								productPayload.getProductStatus(),
								supplier
							);
		product = productRepo.save(product);
		return product;
	}

	@Override
	public Product update(Integer id, ProductPayload productPayload) throws BadRequestException {
		Supplier supplier = supplierRepo.findById(productPayload.getSupplierId()).orElse(null);
		Product product = productRepo.findById(id).orElseThrow(() -> new BadRequestException("Product with id: " + id + " not found!"));
		product.setProductName(productPayload.getProductName());
		product.setPrice(productPayload.getPrice());
		product.setQuantity(productPayload.getQuantity());
		product.setProductStatus(productPayload.getProductStatus());
		product.setUpdatedTime(new Date());
		product.setSupplier(supplier);
		product = productRepo.save(product);
		return product;
	}

	@Override
	public String delete(Integer id) {
		productRepo.deleteById(id);
		return "Product with id: " + id + " has been deleted!";
	}

	@Override
	public Product readById(Integer id) {
		Product product = productRepo.findById(id).orElse(null);
		return product;
	}
	
}
