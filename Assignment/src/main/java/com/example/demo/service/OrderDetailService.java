package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.User;
import com.example.demo.repository.IOrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private IOrderDetailRepository repository;

	// Select all
	public List<OrderDetail> getAll() {
		return repository.findAll();
	}
	public List<OrderDetail> selectPagination(Pageable page) {
		return (List<OrderDetail>) repository.findAll(page);
	}
	// insert row
	public OrderDetail insert(OrderDetail cartDetail) {
		
		return repository.save(cartDetail);
	}
	public Optional<OrderDetail> selectById(Integer id) {
		
		return repository.findById(id);
	}
	// Update row
	public OrderDetail update(OrderDetail cartDetail) {
		Integer id = cartDetail.getId();
		if (id != null) {
			Optional<OrderDetail> towelUpdate = repository.findById(id);
			if (towelUpdate.isPresent()) {
				return repository.save(cartDetail);
			}
		}
		return null;
	}

	// Delete row
	public OrderDetail delete(Integer id) {
		if (id != null) {
			Optional<OrderDetail> cartDetail = repository.findById(id);
			if (cartDetail.isPresent()) {
				repository.deleteById(id);
				return cartDetail.get();
			}
		}
		return null;
	}
	public List<OrderDetail> findByOrderDetail(Order order) {
		return repository.findByOrderId(order);
		
	}
	public List<OrderDetail> findByUserId(User user) {
		return repository.findByUserId(user);
		
	}
}
