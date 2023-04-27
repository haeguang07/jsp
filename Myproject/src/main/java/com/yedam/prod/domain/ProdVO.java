package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProdVO {
//	prod_id NUMBER PRIMARY KEY,
//	prod_name VARCHAR2(100) not null,
//	prod_text VARCHAR2(1000) ,
//	prod_price NUMBER not null,
//	prod_dc NUMBER(3,2) default 0,
//	prod_star number(1)
//	);
	
	private int prodId;
	private String prodName;
	private String prodText;
	private int prodPrice;
	private double prodDc;
	private int prodStar;
	private String prodImg;
	
}
