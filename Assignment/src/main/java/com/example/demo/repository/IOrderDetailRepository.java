package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.User;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> findByOrderId(Order order);
	@Query("SELECT u FROM OrderDetail u JOIN Order o ON u.orderId=o.id WHERE o.userId=:id")
	List<OrderDetail> findByUserId(@Param("id") User user);
	
}
