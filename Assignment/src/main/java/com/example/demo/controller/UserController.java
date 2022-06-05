package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.ultis.EncryptUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	User acc;
	@Autowired
	UserService userService;
	// insert
	@PostMapping("insert")
	public String insertPro(HttpServletRequest request,Model model,@ModelAttribute("userModel") User user) {
		User checkUser=userService.findByEmail(user.getEmail());
		if(checkUser!=null) {
			request.getSession().setAttribute("createError", "Tài khoản đã được đăng ký!");
			model.addAttribute("view","/WEB-INF/views/user/create.jsp");
		}else {
			userService.insert(user);
			request.getSession().setAttribute("createSuccess", "Đăng ký thành công!");
			model.addAttribute("view","/WEB-INF/views/home.jsp");
		}
		return "layout";
	}
	@PostMapping("checklogin")
	public String formUserLogin(HttpServletRequest request,Model model,@ModelAttribute("userModel") User user) {
		acc = userService.findAccount(user.getEmail(),user.getPassword());
		if(acc!=null) {
			request.getSession().setAttribute("account", acc);
			request.getSession().setAttribute("loginSuccess", "Đăng nhập thành công!");
			model.addAttribute("view","/WEB-INF/views/home.jsp");
		}else {
			request.getSession().setAttribute("loginFalse", "Tài khoản hoặc mật khẩu không đúng!");
			model.addAttribute("view","/WEB-INF/views/user/login.jsp");
		}
		return "layout";
	}
	@GetMapping("logout")
	public String logout(HttpServletRequest request,Model model) {
		request.getSession().setAttribute("loginSuccess", "Đăng xuất thành công!");
		model.addAttribute("view","/WEB-INF/views/home.jsp");
		request.getSession().removeAttribute("account");
		return "layout";
	}
	
	public String formUserChangePass(HttpServletRequest request,Model model) {
		String pass = request.getParameter("passNew");
		acc.setPassword(pass);
		userService.update(acc);
		model.addAttribute("view","/WEB-INF/views/user/changePass.jsp");
		return "layout";
	}
	@PostMapping("changePassword")
	private String changePassword(Model model,HttpServletRequest request)
			throws ServletException, IOException {
		String passOld = request.getParameter("passOld");
		String passNew = request.getParameter("passNew");
		String checkPass = request.getParameter("checkPass");
		
		acc = (User) request.getSession().getAttribute("account");
		if(!passOld.equals(acc.getPassword())) {
			request.getSession().setAttribute("changeFalse","Mật khẩu cũ không đúng!");
			model.addAttribute("view","/WEB-INF/views/user/changePass.jsp");
			return "layout";
		}
		if(!passNew.equals(checkPass)) {
			request.getSession().setAttribute("changeFalse","Mật khẩu không trùng khớp!");
			model.addAttribute("view","/WEB-INF/views/user/changePass.jsp");
			return "layout";
		}
		acc.setPassword(passNew);
		request.getSession().setAttribute("loginSuccess","Đổi mật khẩu thành công!");
		userService.update(acc);
		model.addAttribute("view","/WEB-INF/views/home.jsp");
	
		return "layout";
	}
	@PostMapping("updateInfo")
	private String changeInfo(Model model,HttpServletRequest request,@ModelAttribute("userModel") User user)
			throws ServletException, IOException {
		if(user!=null) {
			acc = (User) request.getSession().getAttribute("account");
			acc.setName(user.getName());
			acc.setLocation(user.getLocation());
			acc.setPhone(user.getPhone());
			acc.setAvatar(user.getAvatar());
			acc.setGender(user.getGender());
			request.getSession().setAttribute("updateSuccess","Cập nhật thành công!");
			model.addAttribute("view","/WEB-INF/views/home.jsp");
			userService.update(acc);
			return "layout";
		}else {
			request.getSession().setAttribute("updateFalse","Cập nhật thất bại!");
			model.addAttribute("view","/WEB-INF/views/user/update.jsp");
			return "layout";
		}
	}
}
