package com.netbuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Chris Boucher
 * @date 20/10/2015
 *
 */
@Controller
public class JSPController {
	
	@RequestMapping("/")
	public String index(ModelAndView modelAndView) {
		return "index";
	}

	@RequestMapping("home")
	public String home(ModelAndView modelAndView) {
		return "index";
	}

	@RequestMapping("aboutus")
	public String aboutus(ModelAndView modelAndView) {
		return "aboutus";
	}

	@RequestMapping("addaddresses")
	public String addAddresses(ModelAndView modelAndView) {
		return "addAddresses";
	}

//	@RequestMapping("basket")
//	public String basket(ModelAndView modelAndView) {
//		return "basket";
//	}

	@RequestMapping("cancelledorders")
	public String cancelledOrdersPage(ModelAndView modelAndView) {
		return "cancelledOrdersPage";
	}

	@RequestMapping("contact")
	public String contact(ModelAndView modelAndView) {
		return "contact";
	}

	@RequestMapping("faq")
	public String faq(ModelAndView modelAndView) {
		return "faq";
	}

	@RequestMapping("itempage")
	public String itemPage(ModelAndView modelAndView) {
		return "itemPage";
	}

	@RequestMapping("items")
	public String items(ModelAndView modelAndView) {
		return "items";
	}

	@RequestMapping("loginregister")
	public String loginRegister(ModelAndView modelAndView) {
		return "loginRegister";
	}

	@RequestMapping("openorders")
	public String openOrders(ModelAndView modelAndView) {
		return "openOrdersPage";
	}

	@RequestMapping("orders")
	public String orders(ModelAndView modelAndView) {
		return "ordersPage";
	}

	@RequestMapping("orderconfirm")
	public String orderConfirm(ModelAndView modelAndView) {
		return "orderConfirm";
	}

	@RequestMapping("profile")
	public String profilePage(ModelAndView modelAndView) {
		return "profilePage";
	}

	@RequestMapping("registerconfirmed")
	public String registerConfirmedPage(ModelAndView modelAndView) {
		return "registerConfirmedPage";
	}

	@RequestMapping("wishlist")
	public String wishlist(ModelAndView modelAndView) {
		return "wishlist";
	}

	@RequestMapping("emailOrder")
	public String emailOrder(ModelAndView modelAndView) {
		return "emailOrder";
	}

}
