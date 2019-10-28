package com.customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.frame.Dao;
import com.mapper.CustomerMapper;
import com.vo.Customer;


@Service("cdao")
public class CustomerDao implements Dao<String, Customer> {

	@Autowired(required=true)
	CustomerMapper cm;
	
	@Override
	public void insert(Customer v) throws Exception {
		cm.insert(v);
		
	}

	@Override
	public void update(Customer v) throws Exception {
		cm.update(v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		cm.delete(k);
	}

	@Override
	public Customer select(String k) throws Exception {
		return cm.select(k);
	}

	@Override
	public ArrayList<Customer> select() throws Exception {
		return cm.selectall();
	}

}
