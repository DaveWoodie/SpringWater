/**
 * @author Chris J W Walker
 */

package com.netbuilder.controller;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import email.EmailService;


@Controller
public class EmailController {

    @Autowired 
    private EmailService emailService;



    
    @RequestMapping("/")
    public String root() {
        return "redirect:/index.html";
    }

    
    /* Home page. */
    @RequestMapping("/index.html")
    public String index() {
        return "index.html";
    }

    
    /* Sending confirmation page. */
    @RequestMapping("/sent.html")
    public String sent() {
        return "sent.html";
    }

    
    
    /* 
     * Send HTML mail (simple) 
     */
    @RequestMapping(value = "/sendMailSimple", method = RequestMethod.POST)
    public String sendSimpleMail(
            @RequestParam("recipientName") final String recipientName,
            @RequestParam("recipientEmail") final String recipientEmail,
            final Locale locale) 
            throws MessagingException {

        this.emailService.sendSimpleMail(recipientName, recipientEmail, locale);
        return "redirect:sent.html";
        
    }

    
    
    
    /* 
     * Send HTML mail with attachment. 
     */
    @RequestMapping(value = "/sendMailWithAttachment", method = RequestMethod.POST)
    public String sendMailWithAttachment(
            @RequestParam("recipientName") final String recipientName,
            @RequestParam("recipientEmail") final String recipientEmail,
            @RequestParam("attachment") final MultipartFile attachment,
            final Locale locale) 
            throws MessagingException, IOException {

        this.emailService.sendMailWithAttachment(
                recipientName, recipientEmail, attachment.getOriginalFilename(), 
                attachment.getBytes(), attachment.getContentType(), locale);
        return "redirect:sent.html";
        
    }

    
    
    /* 
     * Send HTML mail with inline image
     */
    @RequestMapping(value = "/sendMailWithInlineImage", method = RequestMethod.POST)
    public String sendMailWithInline(
            @RequestParam("recipientName") final String recipientName,
            @RequestParam("recipientEmail") final String recipientEmail,
            @RequestParam("image") final MultipartFile image,
            final Locale locale)
            throws MessagingException, IOException {

        this.emailService.sendMailWithInline(
                recipientName, recipientEmail, image.getName(), 
                image.getBytes(), image.getContentType(), locale);
        return "redirect:sent.html";
        
    }

    
    
    @ExceptionHandler(Exception.class)
    public String error() {
        return "error.html";
    } 
}