package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
