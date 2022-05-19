package com.zensar.rest;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;

@FeignClient("ZUUL-API-GATEWAY")
@LoadBalancerClient("COUPON-SERVICES")
public interface CouponClient {
	
	@GetMapping("/COUPON-SERVICES/couponapi/coupon/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
