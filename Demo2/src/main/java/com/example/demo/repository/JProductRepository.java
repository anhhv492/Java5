package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface JProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByProductNameLike(String productName);
	List<Product> findByProductNameContains(String productName);
	List<Product> findByProductNameStartsWith(String productName);
	List<Product> findByProductNameEndsWith(String productName);
	List<Product> findByProductNameNotContains(String productName);
}
