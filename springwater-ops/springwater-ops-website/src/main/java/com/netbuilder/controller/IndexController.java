package com.netbuilder.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	
	 
	 @RequestMapping("/")
	    public String home1(Model model) {
	        return "index";
	  }
	 
	 @RequestMapping("/home")
	    public String home2(Model model) {
	        return "index";
	  }
}