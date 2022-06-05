package edu.fpoly.sof3021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fpoly.sof3021.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/new")
	public String newProduct() {
		return "product-new";
	}
	
	@GetMapping("/detail")
	public String showProduct(Model model,
			@RequestParam("name") String name,
			@RequestParam("quantity") Integer quantity) {
		Product p = new Product();
		p.setName(name);
		p.setQuantity(quantity);
		
		model.addAttribute("product", p);
		return "product-detail";
	}
	
	@GetMapping("/new-form")
	public String newFormProduct() {
		return "product-new-form";
	}
	
	@GetMapping("/detail-form")
	public String showProduct(Model model,
			@ModelAttribute("product")Product p) {
		model.addAttribute("product", p);
		return "product-detail";
	}
}
