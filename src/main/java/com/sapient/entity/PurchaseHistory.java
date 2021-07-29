package com.sapient.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseHistory implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private LocalDate billDate;
	private ProductDetail prouductDetail;
	private Double totalBilledAmount;
	private Double totalDiscount;
	private String paymentMode;
	private Integer billNumber;
	private Integer customerId;
	
	
	public PurchaseHistory(LocalDate billDate, ProductDetail prouductDetail, Double totalBilledAmount,
			Double totalDiscount, String paymentMode, Integer billNumber, Integer customerId) {
		super();
		this.billDate = billDate;
		this.prouductDetail = prouductDetail;
		this.totalBilledAmount = totalBilledAmount;
		this.totalDiscount = totalDiscount;
		this.paymentMode = paymentMode;
		this.billNumber = billNumber;
		this.customerId = customerId;
	}
	
}
