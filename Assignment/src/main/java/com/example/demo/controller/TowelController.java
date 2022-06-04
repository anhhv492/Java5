package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.ProductModel;
import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
import com.example.demo.repository.ITowelRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TowelService;

@Controller
@RequestMapping("/towel")
public class TowelController {
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	@Autowired
	ITowelRepository service;

	private static Integer idu=null;
	// pagination (start form)
	
	// form insert
	@GetMapping("/new")
	
	public String productNew(Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		Towel twl = new Towel();
		model.addAttribute("towelModel",twl);
		model.addAttribute("view","/WEB-INF/views/admin/towel/create.jsp");
		return "layout";
	}
	// insert
	@PostMapping("/insert")
	public String insertPro(@ModelAttribute("towelModel") Towel product) {
		towelService.insert(product);
		return "redirect:/towel/get-all";
	}
	//form update
	@GetMapping("/update")
	public String productViewUpdate(@RequestParam("id") Integer ids,Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		idu=ids;
		Optional<Towel> twl = towelService.selectById(idu);
		model.addAttribute("towelModel",twl);
		model.addAttribute("view","/WEB-INF/views/admin/towel/update.jsp");
		return "layout";
	}
	//update
	@RequestMapping(value = "/store",method = RequestMethod.POST)
	public String updateTowel(Model model,@ModelAttribute("towelModel")Towel towel) {
		towel.setId(idu);
		towelService.update(towel);
		model.addAttribute("listPro",towelService.getAll());
		return "redirect:/towel/get-all";
	}
	
	// delete
	@RequestMapping("/delete")
	public String deleteTowel(Model model,@RequestParam("id") Integer id) {
		towelService.delete(id);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",towelService.getAll());
		return "redirect:/towel/get-all";
	}
	//select towel by cateId
	@RequestMapping("/select/{cateId}")
	public String selectByCateId(Model model, @PathVariable("cateId") Integer cateId) {
		Optional<Category> cate = cateService.findById(cateId);
		List<Towel> list= towelService.selectByCateId(cate);
		model.addAttribute("listPro",list);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		return "admin/towel/show";
	}
	@PostMapping("/checkAll")
	public String checkAll(Model model) {
		model.addAttribute("checkAll","checkAll");
		List<Towel> list = towelService.getAll();
		model.addAttribute("list",list);
		return "admin/towel/index";
	}
}
