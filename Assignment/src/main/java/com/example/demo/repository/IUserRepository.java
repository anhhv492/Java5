package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	User findByEmailLike(String email);
	User findByEmailAndPassword(String email,String password);
}
