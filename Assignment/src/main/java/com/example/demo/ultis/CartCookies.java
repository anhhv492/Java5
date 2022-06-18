package com.example.demo.ultis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Towel;
import com.example.demo.service.TowelService;

public class CartCookies {   
	@Autowired
	TowelService towelService;
	
    public void setCartCookie(Integer id,HttpServletResponse response) {
    	String idTowel = String.valueOf(id);
    	Cookie cookie = new Cookie(idTowel,"cart");
    	cookie.setMaxAge(12*60*60);
    	cookie.setPath("/");
    	response.addCookie(cookie);
    }
   
}
