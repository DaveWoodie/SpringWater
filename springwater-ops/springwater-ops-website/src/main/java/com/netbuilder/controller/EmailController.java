/**
 * @author Chris J W Walker
 */

package com.netbuilder.controller;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import email.EmailService;


@Controller
public class EmailController {

 
    private EmailService emailService;



    @RequestMapping(value = "/sendMailSimple", method = RequestMethod.POST)
    public String sendSimpleMail(
            @RequestParam("firstNameInput") final String recipientName,
            @RequestParam("emailinput") final String recipientEmail,
            final Locale locale) 
            throws MessagingException {

        this.emailService.sendSimpleMail(recipientName, recipientEmail, locale);
        return "redirect:/";
        
    }
}