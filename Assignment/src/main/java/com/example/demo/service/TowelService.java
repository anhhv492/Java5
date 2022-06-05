package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
import com.example.demo.repository.ITowelRepository;

@Service
public class TowelService {
	@Autowired
	private ITowelRepository repository;


	// Select all
	public List<Towel> getAll() {
		return repository.findAll();
	}
	public List<Towel> selectPagination(Pageable page) {
		return (List<Towel>) repository.findAll(page);
	}
	// insert row
	public void insert(Towel towel) {
		Date now = new Date();
		towel.setCreatedDate(now);
		repository.save(towel);
	}

	// Update row
	public Towel update(Towel p) {
		Integer id = p.getId();
		if (id != null) {
			Optional<Towel> towelUpdate = repository.findById(id);
			if (towelUpdate.isPresent()) {
				Date now = new Date();
				p.setCreatedDate(now);
				return repository.save(p);
			}
		}
		return null;
	}

	// Delete row
	public Towel delete(Integer id) {
		if (id != null) {
			Optional<Towel> p = repository.findById(id);
			if (p.isPresent()) {
				repository.deleteById(id);
				return p.get();
			}
		}
		return null;
	}

	// Select byId
	public Optional<Towel> selectById(@PathVariable Integer id) {
		return repository.findById(id);
	}

	// select by type
//	@GetMapping(value = "/product/type",params = "type")
//	public List<Product> selectByType(@RequestParam(name="type",required = false) ProductType type){
//		typePr = ProductType.values();
//		return repository.findByTypeLike(type);
//	}
	// select by name
	public List<Towel> selectByName(@RequestParam(name = "name", required = false) String name) {
		return repository.findByNameLike("%" + name + "%");
	}
	public List<Towel> selectByCateId(Optional<Category> cate) {
		return repository.findByCategoryLike(cate);
	}
}
