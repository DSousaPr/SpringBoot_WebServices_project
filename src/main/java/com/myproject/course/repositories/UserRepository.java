package com.myproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
