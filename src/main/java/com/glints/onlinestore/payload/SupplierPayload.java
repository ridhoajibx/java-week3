package com.glints.onlinestore.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class SupplierPayload {
	
	@NotBlank(message = "Name is required!")
	@Size(min=3, message = "Name min 3 characters!")
	private String name;
	
	@NotBlank(message = "Address is required!")
	@Size(min=3, message = "Address min 3 characters!")
	private String address;
	
	@NotNull(message = "Contact is required!")
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
