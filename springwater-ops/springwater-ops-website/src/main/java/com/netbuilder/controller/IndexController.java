package com.netbuilder.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	
	//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	 
	 @RequestMapping("/")
	    public String home1(Model model) {
		 	//model.addAttribute("discontinuedProducts", discontinuedProducts);
	        return "index";
	  }
	 
	 @RequestMapping("/home")
	    public String home2(Model model) {
		 	//model.addAttribute("discontinuedProducts", discontinuedProducts);
	        return "index";
	  }
}