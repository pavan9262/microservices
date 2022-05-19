package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.repository.ProductRepository;
import com.zensar.rest.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductRepository productRepository;
	
	/*@Autowired
	private CouponClient client;*/

	@RequestMapping(value="/product",  method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		//Coupon coupon = restTemplate.getForObject("http://localhost:9000/couponapi/coupon/" + product.getCode(),Coupon.class);
		Coupon coupon = restTemplate.getForObject("http://COUPON-SERVICES/couponapi/coupon/" + product.getCode(),Coupon.class);
		//Coupon coupon=client.getCoupon(product.getCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);
	}
}
