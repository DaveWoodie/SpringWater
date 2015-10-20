package serverrunner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController {
	
	 @RequestMapping("/")
	    public String index(ModelAndView modelAndView) {
	        return "index.jsp";
	  }
	 
	 @RequestMapping("/home")
	    public String home(ModelAndView modelAndView) {
	        return "index.jsp";
	  }
}
