package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.repository.ICartRepository;

@Service
public class CartService {
	@Autowired
	ICartRepository repository;
	public Optional<Cart> findById(Integer id) {
		return repository.findById(id);
	}
	// Select all
	public List<Cart> getAll() {
		return repository.findAll();
	}
	public Page<Cart> selectPagination(Pageable page) {
		Page<Cart> list = repository.findAll(page);
		return list;
	}
	// insert row
	public void insert(Cart cart) {
		repository.save(cart);
	}

	// Update row


	// Delete row
	public Cart delete(Integer id) {
		if (id != null) {
			Optional<Cart> p = repository.findById(id);
			if (p.isPresent()) {
				repository.deleteById(id);
				return p.get();
			}
		}
		return null;
	}
	public void deleteAll() {
		repository.deleteAll();
	}
}	
