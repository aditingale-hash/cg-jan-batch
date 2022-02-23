package com.springproject.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //<-- This tells spring that this class is a controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView showHome(Model model, HttpServletRequest request) {
		//passing the data to JSP 
		
		/*
		 * Type 1: Using Model interface
		 */
		model.addAttribute("msg_model", "Hello Model");
		
		/*
		 * Type 2: HttpServletRequest class
		 */
		request.setAttribute("msg_request", "Hello Request");
		
		/*
		 * Type 3: ModelAndView class
		 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg_mav", "Hello ModelAndView");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping("/products")
	public String showProducts() {
		return "product";
	}

}
