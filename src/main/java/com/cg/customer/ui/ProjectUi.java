package com.cg.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customer.entities.Customer;
import com.cg.customer.service.ICustomerService;
import com.cg.customer.service.CustomerServiceImpl;

@Component
public class ProjectUi {
	@Autowired
	private ICustomerService service ;

	public void runUi() {
		Customer customer = add("Anish");
		long id1 = customer.getId();
		Customer customer2 = add("abcd");
		long id2 = customer2.getId();
		Customer customer3 = add("xyz");
		long id3 = customer3.getId();
		customer2=updateName(id2, "Ramesh");
		//System.out.println(customer2.getName());
	}

	public Customer add(String name) {
		Customer customer = new Customer(name);
		customer = service.register(customer);
		System.out.println("Customer added with details, id=" + customer.getId() + " name=" + customer.getName());
		return customer;
	}
	public Customer updateName(long id,String name) {
		Customer customer = service.updateName(id,name);
		System.out.println("Customer details updated, id=" + customer.getId() + " name=" + customer.getName());
		return customer;
	}
	}
