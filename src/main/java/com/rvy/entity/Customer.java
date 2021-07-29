package com.rvy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "customer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer customerId;
	private String name;
	private String email;
	private Long contactNumber;
	private Integer uin;
	private LocalDate birthDate;
	private String address1;
	private String address2;
	
	//private List<PurchaseHistory> purchaseHistory;
	
	public Customer(String name, String email,Long contactNumber,Integer uin, LocalDate birthDate,String address1,String address2) {
		super();
		this.name = name;
		this.email=email;
		this.contactNumber = contactNumber;
		this.uin = uin;
		this.birthDate = birthDate;
		this.address1 = address1;
		this.address2 = address2;
		//this.purchaseHistory=purchaseHistory;
	}

	public Customer(Integer customerId,String name, String email,Long contactNumber,Integer uin,String address1,String address2) {
		super();
		this.customerId=customerId;
		this.name = name;
		this.email=email;
		this.contactNumber = contactNumber;
		this.uin = uin;
		this.address1 = address1;
		this.address2 = address2;
		//this.purchaseHistory=purchaseHistory;
	}
}
