package com.ansari.repository;

import com.ansari.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String couponCode);
}
