package com.glints.onlinestore.payload;

import lombok.Data;

@Data
public class SupplierPayload {
	private String name;
	private String address;
	private long contact;
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public long getContact() {
		return contact;
	}	
}
