package com.glints.onlinestore.payload;

import com.glints.onlinestore.model.Product;

import lombok.Data;

@Data
public class ProductPayload {
	private String productName;
	private Integer price;
	private Integer quantity;
	private Product.ProductStatus productStatus;
	private Integer supplierId;
	
	public String getProductName() {
		return productName;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Product.ProductStatus getProductStatus() {
		return productStatus;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	
}
