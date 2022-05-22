package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
