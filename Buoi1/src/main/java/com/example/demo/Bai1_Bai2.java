package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.method.Student;

@Controller
public class Bai1_Bai2 {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	// sau "/"
	public String helloPathVarTable(@PathVariable String name) {
		return "Hi" + name;

	}

	@RequestMapping("/xinchao")
	@ResponseBody
	// sau "?"
	public String helloRequestParam(@RequestParam String giaTri) {
		if (giaTri == null || "".equals(giaTri)) {
			giaTri = "spring";
			return giaTri;
		}
		return "hello Spring";

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
	@RequestMapping({"/pathvariable/{value}","/{value}/pathvariable"})
	@ResponseBody
	public String bai6(@PathVariable String value) {
		
		return value;
	}
	@RequestMapping("/requestparam/{name}")
	@ResponseBody
	// sau "/"
	public String bai7(@PathVariable String name) {
		return "Hi" + name;

	}
	@RequestMapping("/hello/redirect")
	public String bai8() {
		return "redirect:/about.html";
	}
	@RequestMapping("/hello/forward")
	public String bai9() {
		return "forward:/about.html";
	}
}
