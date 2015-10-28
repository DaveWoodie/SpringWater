package com.netbuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.test.UserDatabase;

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
	public String getProfileUsers(Model model) {
		String userID = "01";
		model.addAttribute("profile", UserDatabase.users(userID));
		return "profilePage";
	}
}
