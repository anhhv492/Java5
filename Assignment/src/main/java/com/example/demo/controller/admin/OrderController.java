package com.example.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TowelService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	
	
	@RequestMapping("update")
	public String update(Model model,@RequestParam("id") Integer id) {
		Optional<Order> order = orderService.selectById(id);
		order.get().setStatus(1);
		orderService.update(order.get());
		return "forward:/admin/orders/get-all";
	}
	@RequestMapping("delete")
	public String delete(Model model,@RequestParam("id") Integer id) {
		Optional<Order> order = orderService.selectById(id);
		List<OrderDetail> listOrderDetail= orderDetailService.findByOrderDetail(order.get());
		for(int i=0;i<listOrderDetail.size();i++) {
			
			orderDetailService.delete(listOrderDetail.get(i).getId());
		}
		orderService.delete(id);
		return "forward:/admin/orders/get-all";
	}
}
