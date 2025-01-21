package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	 Cart findByUserId(Long userId);
}
