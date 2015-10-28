package com.netbuilder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loaders.WebLoginLoader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import encryption.EncryptPassword;

@Controller
public class loginController {
	
	@RequestMapping(value = "loginForm", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		WebLoginLoader l = new WebLoginLoader();
 		String returned = "redirect:/loginregister";
 		EncryptPassword n = new EncryptPassword(); 
		
 		String email = request.getParameter("emailAddressInput");
 		String passwd = request.getParameter("passwordInputLogin");
 		
 		System.out.println(email);
 		System.out.println(passwd);
 		
 		String userID = "001";
		session.setAttribute("sessionUser", userID);
 		
 		String[] s = new String[2];
	
 		try {
 			s = l.getLoginByEmail(email);
 			System.out.println(s[0]);
 			System.out.println(s[1]);
 			
 			if (s[0].equals(email) && s[1].equals(n.checkSHA1(passwd))) { 
 				returned = "redirect:";
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return returned;
 	}
}
