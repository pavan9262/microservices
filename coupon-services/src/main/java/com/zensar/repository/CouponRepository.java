package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

	Coupon findByCode(String code);
	
}
