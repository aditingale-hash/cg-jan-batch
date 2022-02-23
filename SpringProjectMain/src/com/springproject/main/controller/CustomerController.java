package com.springproject.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.main.beans.Customer;
import com.springproject.main.service.CustomerService;

@Controller
public class CustomerController {

	private CustomerService customerService = new CustomerService();
	
	@RequestMapping("/customer")
	public String showCustomer(Model model) {
		Customer customer = customerService.fetchCustomer(3);
		model.addAttribute("customer", customer);
		return "customer";
	}
}
