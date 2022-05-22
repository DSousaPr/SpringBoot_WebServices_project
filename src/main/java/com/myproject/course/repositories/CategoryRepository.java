package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
