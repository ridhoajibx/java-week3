package com.glints.onlinestore.payload;

import java.util.Date;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SalePayload {
	
	@Min(1)
	private Integer productId;
	
	@Min(1)
	private Integer memberId;
	
	private Integer totalPrice;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7")
	private Date transactionDate;
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public Integer getProductId() {
		return productId;
	}
	public Integer getMemberId() {
		return memberId;
	}
}
