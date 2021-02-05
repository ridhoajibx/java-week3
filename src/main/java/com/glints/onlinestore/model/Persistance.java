package com.glints.onlinestore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@MappedSuperclass
@Data
public class Persistance {

	@Column(length = 50)
	@CreatedBy
	@JsonIgnore
	private String createdBy;

	@Column(length = 50)
	@LastModifiedBy
	@JsonIgnore
	private String updatedBy;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTime;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedTime;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}

