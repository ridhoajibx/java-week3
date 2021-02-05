package com.glints.onlinestore.payload;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberPayload {
	private String firstname;
	private String surname;
	private String address;
	private long contact;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
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
