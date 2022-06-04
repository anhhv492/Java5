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

	private static Integer idp=null;
	// getall ()
	@GetMapping("/get-all")
	public String towelView(Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",towelService.getAll());
		return "admin/towel/index";
	}
	// pagination (start form)
	@GetMapping("/pagination")
	public String next(Model model,@RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 7);
		Page<Towel> pages =service.findAll(pageable);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",pages);
		System.out.println("as");
		return "admin/towel/index";
	}
	// form insert
	@GetMapping("/new")
	public String productNew(Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		return "admin/towel/create";
	}
	// insert
	@PostMapping("/insert")
	public String insertPro(@ModelAttribute("towelModel") Towel product) {
		towelService.insert(product);
		return "redirect:/towel/pagination";
	}
	//form update
	@GetMapping("/update")
	public String productViewUpdate(@RequestParam("id") Integer id,Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		idp=id;
		return "admin/towel/update";
	}
	//update
	@RequestMapping(value = "/store",method = RequestMethod.POST)
	public String updateTowel(Model model,@ModelAttribute("towelModel")Towel towel) {
		towel.setId(idp);
		towelService.update(towel);
		model.addAttribute("listPro",towelService.getAll());
		return "redirect:/towel/pagination";
	}
	
	// delete
	@RequestMapping("/delete")
	public String deleteTowel(Model model,@RequestParam("id") Integer id) {
		towelService.delete(id);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",towelService.getAll());
		return "redirect:/towel/pagination";
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
	
}
