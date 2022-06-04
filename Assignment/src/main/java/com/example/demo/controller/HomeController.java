package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TowelService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping()
	public String getAll() {
		return "home";
	}
	
}
