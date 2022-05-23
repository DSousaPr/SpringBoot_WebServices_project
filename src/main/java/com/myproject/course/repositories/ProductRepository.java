package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
