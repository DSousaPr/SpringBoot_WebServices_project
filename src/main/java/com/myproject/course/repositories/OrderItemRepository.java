package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
