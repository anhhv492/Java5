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
		p.setProductName("sanpham1");
		p.setProductName("qweqwe");
		return repository.save(p);
	}
	@RequestMapping("/update")
	public Product update() {
		Product p = new Product();
		p.setProductName("sanpham9999");
		p.setProductId(1);
		return repository.save(p);
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(name = "name",required = false) Long id) {
	
		repository.deleteById(id);
	}
	@RequestMapping("/get-by-name-like")
	public List<Product> listByNameLike(){
		return repository.findByProductNameLike("%s%");
	}
	@RequestMapping("/get-by-name-contain")
	public List<Product> listByNameContent(){
		return repository.findByProductNameLike("%p%");
	}
}
