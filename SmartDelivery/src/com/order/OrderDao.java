package com.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.OrDependenciesDao;
import com.mapper.OrderMapper;
import com.vo.Order;

@Repository("odao")
public class OrderDao implements OrDependenciesDao<String, Order> {

	@Autowired(required=true)
	OrderMapper om;
	
	
	@Override
	public void insert(Order v) throws Exception {
		om.insert(v);		
	}

	@Override
	public void update(Order v) throws Exception {
		om.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		om.delete(k);
	}

	@Override
	public ArrayList<Order> select(String k) throws Exception {
		return om.select(k);
	}
	
	
	@Override
	public ArrayList<Order> select() throws Exception {
		return om.selectall();
	}

	@Override
	public Order oidmaxselect() throws Exception {
		return om.oidmaxselect();
	}

	@Override
	public Order select_oid(String obj) throws Exception {
		return om.select_oid(obj);
	}

	@Override
	public Order select_rec(String obj) throws Exception {
		return om.recmaxselect(obj);
	}	
}
