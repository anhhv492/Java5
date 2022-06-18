package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Category;
import com.example.demo.repository.ICategoryRepository;

@Service
public class CategoryService {
	ICategoryRepository repository;
	public CategoryService(ICategoryRepository repository) {
		this.repository = repository;
	}	
	public Optional<Category> findById(Integer id) {
		return  repository.findById(id);
	}
	// Select all
	public List<Category> getAll() {
		return repository.findAll();
	}
	public Page<Category> selectPagination(Pageable page) {
		Page<Category> list = repository.findAll(page);
		return list;
	}
	// insert row
	public void insert(Category category) {
		repository.save(category);
	}

	// Update row
	public Category update(Category p) {
		Integer id = p.getId();
		if (id != null) {
			Optional<Category> towelUpdate = repository.findById(id);
			if (towelUpdate.isPresent()) {
				return repository.save(p);
			}
		}
		return null;
	}

	// Delete row
	public Category delete(Integer id) {
		if (id != null) {
			Optional<Category> p = repository.findById(id);
			if (p.isPresent()) {
				repository.deleteById(id);
				return p.get();
			}
		}
		return null;
	}

	// Select byId
	public Optional<Category> selectById(@PathVariable Integer id) {
		return repository.findById(id);
	}
	//select by name
	public Category selectByName(String name) {
		Category category = repository.findByNameLike(name); 
		return category;
	}
	
}
