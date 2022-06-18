package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;

public interface IOrderRepository extends JpaRepository<Order, Integer>{
	@Query("SELECT p FROM Order p ORDER BY p.id DESC")
	List<Order> searchNewOrder();
	List<Order> findByUserId(User user);
	
}
