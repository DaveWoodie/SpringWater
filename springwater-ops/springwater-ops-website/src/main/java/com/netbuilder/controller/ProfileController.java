package com.netbuilder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.User;

/**
 * 
 * @author ccooper
 * @date 28/10/2015
 * @description file contains the profile controller.
 * @lastModified 28/10/2015
 *
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getProfileUsers(Model model, HttpSession session) {
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
			return "profilePage";
		}
		return "redirect:loginregister";
	}
}
