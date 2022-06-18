package com.example.demo.controller.admin;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Order;
import com.example.demo.entity.Towel;
import com.example.demo.entity.User;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.ITowelRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TowelService;

@Controller
// All-Form clicker layout 
public class HomeController {
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	@Autowired
	OrderService orderService;

	@RequestMapping("/home")
	public String home(Model model,HttpServletRequest request) {
		List<Category> listCate = cateService.getAll();
		request.getSession().setAttribute("listCates", listCate);
		model.addAttribute("view","/WEB-INF/views/home.jsp");
		return "layout";
	}
	// manage-towel
	@GetMapping("admin/towels/get-all")
	public String indexTowel(Model model,@RequestParam("page") Optional<Integer> page,@ModelAttribute("towelSeach") Towel towels) {
		Pageable pageable = PageRequest.of(page.orElse(0), 5);
		Page<Towel> pages =towelService.selectPagination(pageable);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",pages);
		model.addAttribute("view","/WEB-INF/views/index/towel.jsp");
		return "layout";
	}
	// manage-category
	@GetMapping("admin/categories/get-all")
	public String indexCategory(Model model,@RequestParam("page") Optional<Integer> page,@ModelAttribute("cateModel")Category category) {
		Pageable pageable = PageRequest.of(page.orElse(0), 4);
		Page<Category> pages =cateService.selectPagination(pageable);
		model.addAttribute("listCategories",pages);
		model.addAttribute("view","/WEB-INF/views/index/category.jsp");
		return "layout";
	}
	// manage-order
	@GetMapping("admin/orders/get-all")
	public String indexOrder(Model model,@RequestParam("page") Optional<Integer> page,@ModelAttribute("orderModel")Order order) {
		Pageable pageable = PageRequest.of(page.orElse(0), 7);
		Page<Order> pages = orderService.selectPagination(pageable);
		model.addAttribute("listOrders",pages);
		model.addAttribute("view","/WEB-INF/views/admin/index/order.jsp");
		return "layout";
	}
	// user-sign up
	@GetMapping("user/create")
	public String formUserNew(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/create.jsp");
		return "layout";
	}
	// user-login
	@GetMapping("user/login")
	public String formUserLogin(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/login.jsp");
		return "layout";
	}
	// user-changePass
	@GetMapping("user/fChangePass")
	public String formUserChangePass(Model model) {
		model.addAttribute("view","/WEB-INF/views/user/changePass.jsp");
		return "layout";
	}
	// user-updateInfo
	@GetMapping("user/edit")
	public String formUserEditInfo(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/update.jsp");
		return "layout";
	}
	
}
