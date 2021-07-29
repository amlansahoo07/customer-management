package com.sapient.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Data
@Table(name = "customer_details")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer customerId;
	private String name;
	private Long contactNumber;
	private Integer uin;
	private LocalDate birthDate;
	private PurchaseHistory purchaseHistory;
	
	
	public Customer(String name, Long contactNumber, Integer uin, LocalDate birthDate,
			PurchaseHistory purchaseHistory) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.uin = uin;
		this.birthDate = birthDate;
		this.purchaseHistory = purchaseHistory;
	}
}
