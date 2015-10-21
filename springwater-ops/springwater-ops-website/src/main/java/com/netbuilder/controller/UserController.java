package com.netbuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping("/hello")
	public String userName(Model model) {
		model.addAttribute("message", "Hello World");
		return "hello";
	}
}
