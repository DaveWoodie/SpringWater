/**
 * @author Chris J W Walker
 */

package com.netbuilder.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import email.EmailService;


@Controller
public class EmailController {

 
    EmailService emailService = new EmailService();

    @RequestMapping(value = "sendMailSimple", method = RequestMethod.POST)
    public String sendSimpleMail(
    		@RequestParam("firstNameInput") final String firstName, 
    		@RequestParam("lastNameInput") final String lastName, 
    		@RequestParam("emailInput") final String email,
    		@RequestParam("telephoneNumberInput") final String phone) throws MessagingException {

    	EmailService.Send("chrisjwwalker@gmail.com","ThePhotographer", firstName, lastName, email, phone);
    	
        return "redirect:/aboutus";     
    }
}