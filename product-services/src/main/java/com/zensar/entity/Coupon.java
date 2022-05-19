package com.zensar.entity;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
