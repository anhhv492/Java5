package com.example.demo.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductType;
import com.example.demo.repository.JProductRepository;

@RestController

public class ProductController {
	ProductType[] typePr;
	@Autowired
	private JProductRepository repository;
	// Insert
	@PostMapping("/product")
	public String insertPro() {
		typePr = ProductType.values();
		Date now = new Date();
		Product p = new Product();
		p.setCount(100);
		p.setCreatedDate(now);
		p.setType(typePr[2]);
		p.setName("ProductOld");
		repository.save(p);
		return "Insert thanh cong";
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
	@GetMapping(value = "/product/type",params = "type")
	public List<Product> selectByType(@RequestParam(name="type",required = false) ProductType type){
		typePr = ProductType.values();
		return repository.findByTypeLike(type);
	}
	// select by name
	@GetMapping(value = "/product",params = "name")
	public List<Product> selectByName(@RequestParam(name="name",required = false) String name){
		return repository.findByNameLike("%"+name+"%");
	}
	// Update row
	@PutMapping("/product/{id}")
	public Product updateById(@PathVariable Integer id) {
		Product p = new Product();
		p.setColor("colorNew");
		p.setName("Sản phẩm mới");
		p.setId(id);
		p.setType(typePr[1]);
		return repository.save(p);
	}
	// Delete row
	@DeleteMapping("/product/{id}")
	public String deleteById(@PathVariable Integer id) {
		repository.deleteById(id);
		return "Delete thành công mã: "+id;
	}

}
