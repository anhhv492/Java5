package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.JProductRepository;

@RestController
public class ProductController {
	@Autowired
	private JProductRepository repository;
	
	@RequestMapping("/get-all")
	public List<Product> getAll(){
		return repository.findAll();
	}
	@RequestMapping("/add")
	public Product add() {
		Product p = new Product();
		p.setName("sanpham1");
		return repository.save(p);
	}
	@RequestMapping("/update")
	public Product update() {
		Product p = new Product();
		p.setName("sanpham9999");
		p.setId(1L);
		return repository.save(p);
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(name = "name",required = false) Long id) {
	
		repository.deleteById(id);
	}
}
