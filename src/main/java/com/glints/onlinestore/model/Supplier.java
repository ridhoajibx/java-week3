package com.glints.onlinestore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends Persistance {
		
	public Supplier() {
		super();
	}
	
	public Supplier(String name, String address, long contact) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.setCreatedTime(new Date());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 255)
	private String name;
	
	@Column(columnDefinition = "text")
	private String address;
	
	@Column
	private long contact;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
}
