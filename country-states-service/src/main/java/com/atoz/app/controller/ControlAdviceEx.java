package com.atoz.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ControlAdviceEx {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Excepton", ex.getStackTrace());
		mv.addObject("URL", request.getRequestURL());
		mv.setViewName("error");
		return mv;

	}

}
