package com.ansari.repository;

import com.ansari.model.Cart;
import com.ansari.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);


}
