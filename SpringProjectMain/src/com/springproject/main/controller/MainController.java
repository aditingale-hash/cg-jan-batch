package com.springproject.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.main.beans.Employee;

@Controller //<-- This tells spring that this class is a controller
public class MainController {
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/")
	public ModelAndView showHome(Model model,ModelAndView mav , HttpServletRequest request) {
		//passing the data to JSP 
		
		/*
		 * Type 1: Using Model interface
		 */
		model.addAttribute("msg_model", "Hello Model");
		model.addAttribute("employee", employee);
		
		/*
		 * Type 2: HttpServletRequest class
		 */
		request.setAttribute("msg_request", "Hello Request");
		
		/*
		 * Type 3: ModelAndView class
		 */
		mav.addObject("msg_mav", "Hello ModelAndView");
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping("/product")
	public String showProducts(Model model, HttpServletRequest request) {
		//based on the link clicked, I will do something
		String cname = request.getParameter("name");
		 model.addAttribute("cname", cname);
		 
		return "product";
	}

}




