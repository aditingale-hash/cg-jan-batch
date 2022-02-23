package com.springproject.main.service;

import com.springproject.main.beans.Customer;

public class CustomerService {

	public Customer fetchCustomer(int id) {
		Customer c = new Customer(1,"harry potter","hogwards",19);
		return c;
	}

}
