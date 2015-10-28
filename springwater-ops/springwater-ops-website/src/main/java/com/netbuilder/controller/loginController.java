package com.netbuilder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loaders.WebLoginLoader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {
	
	@RequestMapping(value = "loginForm", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String email = request.getParameter("emailAddressInput");
		String passwd = request.getParameter("passwordInputLogin");
		
		String userID = "001";
		
		session.setAttribute("sessionUser", userID);
		
		System.out.println(email);
		System.out.println(passwd);
		
		String[] s = new String[2];
		
//		WebLoginLoader l = new WebLoginLoader();
//		
//		try {
//			
//			s = l.getLoginByEmail(email);
//			System.out.println(s[0]);
//			System.out.println(s[1]);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
		return "redirect:/loginregister";
	}
}
