package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.ICategoryRepository;

@Service
public class CategoryService {
	ICategoryRepository repository;
	public CategoryService(ICategoryRepository repository) {
		this.repository = repository;
	}	
	public List<Category> getAll() {
		return repository.findAll();
	}
	public Optional<Category> findById(Integer id) {
		return  repository.findById(id);
	}
}
