package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Student;

@Controller
public class Bai12Controller {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	// sau "/"
	public String helloPathVarTable(@PathVariable String name) {
		return "Hi" + name;

	}
	@RequestMapping({"/student","/hello"})
	@ResponseBody
	public Student getStudent() {
		Student st = new Student();
		st.setId(1L);
		st.setName("vanhvs");
		return st;
	}
	
	// lab 1 + lab 2 - AnhHVPH14045
	@RequestMapping("/hello/message")
	@ResponseBody
	public String bai2() {
		return "hello AnhHVPH14045";
	
	}
	@RequestMapping("/hello/view")
	public String bai3() {
		return "NewFile";
	}
	@RequestMapping("/about.html")
	public String bai4() {
		return "about";
	}
	@PostMapping("/gppd")
	@ResponseBody
	public String bai8Post() {
		return "Post: VietAnh PH14045";
	}
	@PutMapping("/gppd")
	@ResponseBody
	public String bai8Put() {
		return "Put: VietAnh PH14045";
	}
	@GetMapping("/gppd")
	@ResponseBody
	public String bai8Get() {
		return "Get: VietAnh PH14045";
	}
	@DeleteMapping("/gppd")
	@ResponseBody
	public String bai8Delete() {
		return "Delete: VietAnh PH14045";
	}
	@RequestMapping({"/path-variable/{value}","/{value}/path-variable"})
	@ResponseBody
	public String bai6(@PathVariable String value) {
		
		return value;
	}
	@RequestMapping("/request-param")
	@ResponseBody
	// sau "?"
	public String helloRequestParam(@RequestParam(name="name",required = false) String giaTri) {
		if (giaTri == null || "".equals(giaTri)) {
			giaTri = "spring";
			return giaTri;
		}
		return "hi: "+ giaTri;

	}
//	@RequestMapping("/request-para")
//	@ResponseBody
//	// sau "/"
//	public String bai7(@RequestParam String name) {
//		return "Hi" + name;
//
//	}
	@RequestMapping("/hello/redirect")
	public String bai8() {
		return "redirect:/about.html";
	}
	@RequestMapping("/hello/forward")
	public String bai9() {
		return "forward:/about.html";
	}
}
