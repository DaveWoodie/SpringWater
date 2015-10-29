package com.netbuilder.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.Faq;
import com.netbuilder.test.FaqDatabase;

/**
 * 
 * @author Chris Boucher
 * @date 27/10/2015
 *
 */
@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String faq(Model model) {
		ArrayList<Faq> faqList = FaqDatabase.getFaqList();
		model.addAttribute("faqList",faqList);
		return "faq";
	}
}
