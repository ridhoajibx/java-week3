package com.glints.onlinestore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sale")
public class Sale extends Persistance {

	public Sale() {
		super();
	}

	public Sale(Date transactionDate, Product product, Member member, Integer totalPrice) {
		this.transactionDate = transactionDate;
		this.totalPrice = totalPrice;
		this.product = product;
		this.member = member;
		this.setCreatedTime(new Date());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@JoinColumn(name = "product_id")
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private Product product;
	
	@JoinColumn(name = "member_id")
	@ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private Member member;

	@Column
	private Date transactionDate;
	
	@Column
	private Integer totalPrice;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
}
