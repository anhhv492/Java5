package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

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
import com.example.demo.entity.Towel;
import com.example.demo.entity.User;
import com.example.demo.repository.ITowelRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TowelService;

@Controller

public class HomeController {
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	@Autowired
	ITowelRepository service;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("view","/WEB-INF/views/home.jsp");
		return "layout";
	}
	@GetMapping("towel/get-all")
	public String indexTowel(Model model,@RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 7);
		Page<Towel> pages =service.findAll(pageable);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",pages);
		model.addAttribute("view","/WEB-INF/views/index/towel.jsp");
		return "layout";
	}
	@GetMapping("user/create")
	public String formUserNew(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/create.jsp");
		return "layout";
	}
	@GetMapping("user/login")
	public String formUserLogin(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/login.jsp");
		return "layout";
	}
	@GetMapping("user/fChangePass")
	public String formUserChangePass(Model model) {
		model.addAttribute("view","/WEB-INF/views/user/changePass.jsp");
		return "layout";
	}
	@GetMapping("user/edit")
	public String formUserEditInfo(Model model,@ModelAttribute("userModel")User user) {
		model.addAttribute("view","/WEB-INF/views/user/update.jsp");
		return "layout";
	}
}
