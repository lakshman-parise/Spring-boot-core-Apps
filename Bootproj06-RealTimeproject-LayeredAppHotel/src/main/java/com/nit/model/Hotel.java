package com.nit.model;

import lombok.Data;

@Data
//@Table(name="Hotel_Info")
public class Hotel {

	private Integer hno;
	private String cname;
	private String hroom;
	private Double hamount;
	private String hcity;
	private Double hcgstAmount;
	private Double hsgstAmount;
}
