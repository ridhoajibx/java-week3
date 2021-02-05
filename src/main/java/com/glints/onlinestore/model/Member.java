package com.glints.onlinestore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "member")
public class Member extends Persistance {	
	
	public Member() {
		super();
	}

	public Member(String firstname, String surname, String address, long contact, Date expires) {
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
		this.contact = contact;
		this.expires = expires;
		this.setCreatedTime(new Date());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 255)
	private String firstname;	

	@Column(length = 255)
	private String surname;
	
	@Column(columnDefinition = "text")
	private String address;
	
	@Column
	private long contact;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date expires;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}
	
}
