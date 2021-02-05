package com.glints.onlinestore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product extends Persistance {
	
	public Product() {
		super();
	}
		
	public Product(String productName, Integer price, Integer quantity, ProductStatus productStatus,
			Supplier supplier) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productStatus = productStatus;
		this.supplier = supplier;
		this.setCreatedTime(new Date());
	}



	public enum ProductStatus {
		FOR_SELL, OUT_OF_STOCK, HIDE
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 100)
	private String productName;
	
	@Column
	private Integer price;
	
	@Column
	private Integer quantity;
	
	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;
	
	@JoinColumn(name = "supplier_id")
	@ManyToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private Supplier supplier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}	
	
}
