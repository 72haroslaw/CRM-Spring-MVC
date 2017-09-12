package com.rafalzdzieborski.spring.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcomePage");
		return modelAndView;
	}

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homePage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invalid username or password.");
		}
		if (logout != null) {
			modelAndView.addObject("message", "Logged out successfully.");
		}
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}	
}