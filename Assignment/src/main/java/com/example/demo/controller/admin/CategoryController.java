package com.example.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
import com.example.demo.entity.User;
import com.example.demo.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	int idu;
	// form insert
	@GetMapping("/new")
	
	public String categoryNew(Model model,@ModelAttribute("cateModel") Category category) {
		model.addAttribute("view","/WEB-INF/views/admin/categories/create.jsp");
		return "layout";
	}
	@PostMapping("insert")
	public String insertPro(@ModelAttribute("cateModel") Category category,HttpServletRequest request) {
		User acc = (User) request.getSession().getAttribute("account");	
		System.out.println(acc.getName());
		category.setUsers(acc);
		System.out.println(category.getName());
		categoryService.insert(category);
		return "redirect:/admin/categories/get-all";
	}
	//form update
	@GetMapping("update")
	public String categoryViewUpdate(@RequestParam("id") Integer ids,Model model,@ModelAttribute("cateModel") Category cate) {
		idu=ids;
		Optional<Category> twl = categoryService.selectById(idu);
		model.addAttribute("towelModel",twl);
		model.addAttribute("view","/WEB-INF/views/admin/categories/update.jsp");
		return "layout";
	}
	//update
	@RequestMapping(value = "/store",method = RequestMethod.POST)
	public String updateTowel(Model model,@ModelAttribute("cateModel")Category category,HttpServletRequest request) {
		User acc = (User) request.getSession().getAttribute("account");	
		category.setId(idu);
		category.setUsers(acc);
		categoryService.update(category);
		return "redirect:/admin/categories/get-all";
	}
	
	// delete
	@RequestMapping("delete")
	public String deleteTowel(Model model, HttpServletRequest request,@RequestParam("id") Integer id) {
		Optional<Category> cate = categoryService.findById(id);
		if(cate.get().getListTowel().isEmpty()) {
			categoryService.delete(id);
			return "redirect:/admin/categories/get-all";
		}else {
			request.getSession().setAttribute("cateFalse", "Thể loại chứa sản phẩm không thể xóa!");
			return "redirect:/admin/categories/get-all";
		}
	}
	@PostMapping("clickAll")
	public String clickAll(Model model) {
		model.addAttribute("checkAll","checkAll");
		return "redirect:/admin/categories/get-all";
	}
}
