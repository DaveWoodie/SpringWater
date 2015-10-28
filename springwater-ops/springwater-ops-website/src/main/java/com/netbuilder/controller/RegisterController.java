package com.netbuilder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	 @RequestMapping(value="registerForm", method=RequestMethod.POST)
	 public String doPost(HttpServletRequest request, HttpServletResponse response) {
		 
		 String returned = "redirect:";
		 
		 String fName = request.getParameter("firstNameRegisterInput");
		 String lName = request.getParameter("lastNameRegisterInput");
		 String email = request.getParameter("emailRegisterInput");
		 String password = request.getParameter("passwordRegisterInput");
//		 String passwordCheck = request.getParameter("confirmPasswordRegisterInput");
		 String dob = request.getParameter("dobRegisterInput");
		 int phonenumber = Integer.parseInt(request.getParameter("telephoneNumberRegisterInput"));
		 
		 
		 
		 
		 
		 
		 
		 return returned;
	 }
}
