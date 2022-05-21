package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductType;
public interface JProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByTypeLike(Enum type);
	List<Product> findByNameLike(String name);
}
