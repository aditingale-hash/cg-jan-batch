package com.springproject.main.service;

import org.springframework.stereotype.Component;

import com.springproject.main.beans.Customer;

@Component
public class CustomerService {

	public Customer fetchCustomer(int id) {
		Customer c = new Customer(1,"harry potter","hogwards",19);
		return c;
	}

}
