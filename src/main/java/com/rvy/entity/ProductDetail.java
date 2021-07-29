package com.rvy.entity;

import java.io.Serializable;

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
//@Data
public class ProductDetail {

	//private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;
	private Double maxRetailPrice;
	private Double discount;
	private Double sellingPrice;
	
	
}
