package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
public interface ITowelRepository extends JpaRepository<Towel, Integer> {
	List<Towel> findByCategoryLike(Optional<Category> cate);
	List<Towel> findByNameLike(String name);
}
