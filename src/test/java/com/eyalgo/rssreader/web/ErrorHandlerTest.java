package com.eyalgo.rssreader.web;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ErrorHandlerTest {
    @Test
    public void shouldFillModelWithExceptionMessage() throws Exception {
	String message = "this is the message";
	Exception e = new Exception(message);
	ErrorHandler errorHandler = new ErrorHandler();
	ModelAndView modelAndView = errorHandler.handleAllException(e);
	Map<String, Object> model = modelAndView.getModel();
	String actualMessage = (String) model.get("message");
	assertThat(actualMessage, is(message));
    }
}
