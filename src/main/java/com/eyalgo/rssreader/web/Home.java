package com.eyalgo.rssreader.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Home {
    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ModelAndView message() {
	return new ModelAndView("showMessage");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
	return "index";
    }

}