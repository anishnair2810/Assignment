package com.cg.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.cg.customer.dao.*;
import com.cg.customer.entities.Customer;
import com.cg.customer.util.ValidationUtil;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao dao;
	
	@Override
	public Customer register(Customer cust) {
	  ValidationUtil.checkArgumentNotNull(cust);
	  ValidationUtil.checkName(cust.getName());
	  cust=	dao.add(cust);
	   return cust;
	}
	

	@Override
	public Customer updateName(long id,String name) {
		
		Customer cust=dao.update(id,name);
		return cust;
	}

}
