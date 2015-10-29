package com.netbuilder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loaders.WebLoginLoader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.User;
import com.netbuilder.test.UserDatabase;

import encryption.EncryptPassword;

@Controller
public class loginController {
	
	@RequestMapping(value = "loginForm", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("user") != null) {
			return "redirect:";
		}
		WebLoginLoader webLoginLoader = new WebLoginLoader();
 		String returned = "redirect:/loginregister";
 		EncryptPassword n = new EncryptPassword(); 
		
 		String email = request.getParameter("emailAddressInput");
 		String passwd = request.getParameter("passwordInputLogin");
 		
 		System.out.println(email);
 		System.out.println(passwd);
 		
 		//int userID = webLoginLoader.getUserId(email);
 		//User user = UserDatabase.searchID(userID);
 		User user = UserDatabase.userList.get(0);
 
 		String[] s = new String[2];
	
 		try {
 			s = webLoginLoader.getLoginByEmail(email);
 			System.out.println(s[0]);
 			System.out.println(s[1]);
 			
 			if (s[0].equals(email) && s[1].equals(n.checkSHA1(passwd))) {
 				session.setAttribute("user", user);
 				returned = "redirect:";
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return returned;
 	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logOut(HttpSession session) {
		if(session.getAttribute("user") != null)
		{
			session.removeAttribute("user");
		}
		return "redirect:";
	}
}
