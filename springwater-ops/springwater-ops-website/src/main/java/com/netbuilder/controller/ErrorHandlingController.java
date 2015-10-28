package com.netbuilder.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
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
public class ErrorHandlingController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(ModelAndView modelAndView) {
        return "errorPage";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
