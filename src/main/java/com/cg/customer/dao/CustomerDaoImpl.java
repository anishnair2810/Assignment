package com.cg.customer.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.customer.entities.Customer;
import com.cg.customer.exceptions.*;

import java.util.*;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	private Map<Long, Customer> storeMap = new HashMap<>();

	private long genId;

	long generateId() {
		++genId;
		return genId;
	}

	@Override
	public Customer add(Customer customer) {
		long id = generateId();
		customer.setId(id);
		storeMap.put(id, customer);
		return customer;
	}
	
	@Override
	public Customer update(long id,String name) {
		Customer customer=storeMap.get(id);
		customer.setName(name);
		storeMap.put(id, customer);
		return customer;
	}
	
}
