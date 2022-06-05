package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
@Service
public class UserService {
	@Autowired
	private IUserRepository repository;

	// Select all
	public List<User> getAll() {
		return repository.findAll();
	}
	public List<User> selectPagination(Pageable page) {
		return (List<User>) repository.findAll(page);
	}
	// insert row
	public User insert(User userIs) {
		
		return repository.save(userIs);
	}

	// Update row
	public User update(User p) {
		Integer id = p.getId();
		if (id != null) {
			Optional<User> towelUpdate = repository.findById(id);
			if (towelUpdate.isPresent()) {
				return repository.save(p);
			}
		}
		return null;
	}

	// Delete row
	public User delete(Integer id) {
		if (id != null) {
			Optional<User> p = repository.findById(id);
			if (p.isPresent()) {
				repository.deleteById(id);
				return p.get();
			}
		}
		return null;
	}

	// Select byId
	public Optional<User> selectById(@PathVariable Integer id) {
		return repository.findById(id);
	}

	public User findByEmail(String email) {
		User user = repository.findByEmailLike(email);
		return user;
	}
	public User findAccount(String email,String password) {
		User user = repository.findByEmailAndPassword(email, password);
		return user;
	}
}
