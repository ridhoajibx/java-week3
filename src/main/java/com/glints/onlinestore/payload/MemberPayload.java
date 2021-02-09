package com.glints.onlinestore.payload;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberPayload {
	
	@NotBlank(message = "firstname is required!")
	@Size(min=3, message = "firstname min 3 characters!")
	private String firstname;
	
	@NotBlank(message = "surname is required!")
	@Size(min=3, message = "surname min 3 characters!")
	private String surname;
	
	@NotBlank(message = "address is required!")
	@Size(min=3, message = "address min 3 characters!")
	private String address;
	
	@NotNull(message = "contact is required!")
	private long contact;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7")
	@NotNull(message = "Expires date is required!")
	private Date expires;

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	public Date getExpires() {
		return expires;
	}
		
}
