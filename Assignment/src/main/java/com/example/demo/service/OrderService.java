package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Towel;
import com.example.demo.entity.User;
import com.example.demo.repository.IOrderRepository;

@Service
public class OrderService {
	@Autowired
	private IOrderRepository repository;
	@Autowired
	TowelService towelService;
	// Select all
	public List<Order> getAll() {
		return repository.findAll();
	}
	
	public Optional<Order> selectById(Integer id) {
		
		return repository.findById(id);
	}
	public Page<Order> selectPagination(Pageable page) {
		Page<Order> list = repository.findAll(page);
		return list;
	}
	// insert row
	public Order insert(Order cart) {
		
		return repository.save(cart);
	}

	// Update row
	public Order update(Order cart) {
		Integer id = cart.getId();
		if (id != null) {
			Optional<Order> towelUpdate = repository.findById(id);
			if (towelUpdate.isPresent()) {
				return repository.save(cart);
			}
		}
		return null;
	}

	// Delete row
	public Order delete(Integer id) {
		if (id != null) {
			Optional<Order> p = repository.findById(id);
			if (p.isPresent()) {
				repository.deleteById(id);
				return p.get();
			}
		}
		return null;
	}
	public Order selectNew() {
		List<Order> list= repository.searchNewOrder();
		Order order = new Order();
		order=list.get(0);
		return order;
	}
	public List<Towel> getCookieCart(HttpServletRequest request) {
    	Cookie[] cookie = request.getCookies();
    	List<Towel> list = new ArrayList<Towel>();
    	Optional<Towel> towel=null;
    	for(Cookie cc:cookie) {
    		if(cc.getValue().equals("cart")) {
    			int id = Integer.parseInt(cc.getName());
    			towel = towelService.selectById(id);
    			list.add(towel.get());
    		}
    	}
    	return list;
    }
	public void deleteAllCartCookie(HttpServletRequest request,HttpServletResponse response) {
    	Cookie[] cookies= request.getCookies();
    	
    	for (Cookie cookie : cookies) {
    	    cookie.setValue("");
    	    cookie.setMaxAge(0);
    	    cookie.setPath("/");

    	    response.addCookie(cookie);
    	}
	}	
	public List<Order> selectByUserId(User user) {
		return repository.findByUserId(user);
	}
}
