package com.netbuilder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.User;

@Controller
public class AddressController {
	
	@RequestMapping(value="/addaddresses", method = RequestMethod.GET)
	public String loadPage(Model model, HttpSession session) {
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
			return "addAddresses";
		}
		else {
			return "redirect:loginregister";
		}
	}
}
