package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

	@Autowired
	private CouponRepository couponRepository;

	@RequestMapping(value = "/coupon", method = RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepository.save(coupon);
	}

	@RequestMapping(value = "/coupon/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		System.out.println("Server Instance 1");
		return couponRepository.findByCode(code);
	}
}
