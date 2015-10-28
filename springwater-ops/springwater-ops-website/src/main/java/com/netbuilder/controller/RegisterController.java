package com.netbuilder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import adders.WebRegisterAdder;

@Controller
public class RegisterController {

	 @RequestMapping(value="registerForm", method=RequestMethod.POST)
	 public String doPost(HttpServletRequest request, HttpServletResponse response) {
		 
		 String returned = "redirect:";
		 String[] data = new String[4];
		 
		 data[0] = request.getParameter("firstNameRegisterInput");
		 data[1] = request.getParameter("lastNameRegisterInput");
		 data[2] = request.getParameter("emailRegisterInput");
		 data[3] = request.getParameter("passwordRegisterInput");
//		 String passwordCheck = request.getParameter("confirmPasswordRegisterInput");
		 String dob = request.getParameter("dobRegisterInput");
//		 int phonenumber = Integer.parseInt(request.getParameter("telephoneNumberRegisterInput"));
		 
		 WebRegisterAdder a = new WebRegisterAdder();
		 a.addNewUser(data);
		 
		 
		 return returned;
	 }
}
