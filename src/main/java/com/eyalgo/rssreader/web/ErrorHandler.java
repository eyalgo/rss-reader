package com.eyalgo.rssreader.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {

    public ErrorHandler() {
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception e) {
	ModelAndView model = new ModelAndView("error");
	model.addObject("message", e.getMessage());
	return model;

    }

}
