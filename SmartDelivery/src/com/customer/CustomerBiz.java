package com.customer;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Customer;


@Service("cbiz")
public class CustomerBiz implements Biz<String, Customer> {

	@Resource(name="cdao")
	Dao<String, Customer> cdao;
	
	@Override
	public void register(Customer v) throws Exception {
		cdao.insert(v);
		
	}

	@Override
	public void modify(Customer v) throws Exception {
		cdao.update(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		cdao.delete(k);
	}

	@Override
	public Customer get(String k) throws Exception {
		return cdao.select(k);
	}

	@Override
	public ArrayList<Customer> get() throws Exception {
		return cdao.select();
	}

}
