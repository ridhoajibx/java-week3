package com.glints.onlinestore.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.glints.onlinestore.model.Product;

import lombok.Data;

@Data
public class ProductPayload {
	
	@NotBlank(message = "Product name is required!")
	@Size(min=3, message = "Product name min 3 characters!")
	private String productName;
	
	@NotNull(message = "Price is required!")
	private Integer price;
	
	@NotNull(message = "Quantity is required!")
	private Integer quantity;
	
	@NotNull(message = "Product status is required!")
	private Product.ProductStatus productStatus;
	
	@Min(1)
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
