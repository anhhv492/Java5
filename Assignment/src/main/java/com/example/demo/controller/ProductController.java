package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductType;
import com.example.demo.repository.JProductRepository;

@RestController
public class ProductController {
	@Autowired
	private JProductRepository repository;
	// Insert
	@PostMapping("/product")
	public void insertPro() {
		Product p = new Product();
		
		repository.save(p);
	}
	// Select all
	@GetMapping("/product")
	public List<Product> selectAll(){
		return repository.findAll();
	}
	// Select byId
	@GetMapping("/product/{id}")
	public Optional<Product> selectById(@PathVariable Integer id) {
		return repository.findById(id);
	}
	// select by type
	@GetMapping("/product/type")
	public List<Product> selectByType(@RequestParam(name="type",required = false) Integer type){
		ProductType[] typePr = ProductType.values();
		
		return repository.findByTypeLike(typePr[type]);
	}
	// select by name
	@GetMapping("/product/name")
	public List<Product> selectByName(@RequestParam(name="name",required = false) String name){
		return repository.findByNameLike(name);
	}	
	// Update row
	@PutMapping("/product/{id}")
	public void updateById(@PathVariable Integer id) {
		Product p = new Product();
		p.setColor("colorNew");
		p.setName("Sản phẩm mới");
		
		p.setId(id);
		repository.save(p);
	}
	// Delete row
	@DeleteMapping("/product/{id}")
	public void deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
	}

}
