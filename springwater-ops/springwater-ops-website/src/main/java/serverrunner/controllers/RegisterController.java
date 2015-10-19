package serverrunner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	 @RequestMapping(value="/loginRegister", method=RequestMethod.POST)
	 public String registerDetails() {
		 return "profilePage";
	 }
}
