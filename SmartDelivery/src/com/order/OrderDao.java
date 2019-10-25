package com.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.OrDependenciesDao;
import com.mapper.OrderMapper;
import com.vo.Order;

@Repository("odao")
public class OrderDao implements OrDependenciesDao<String, Order> {

<<<<<<< HEAD
	
=======
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	@Autowired(required=true)
	OrderMapper om;
	
	
	@Override
	public void insert(Order v) throws Exception {
<<<<<<< HEAD
		om.insert(v);	
=======
		om.insert(v);		
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
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
<<<<<<< HEAD
=======
	public ArrayList<Order> select(String k) throws Exception {
		return om.select(k);
	}
	
	
	@Override
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	public ArrayList<Order> select() throws Exception {
		return om.selectall();
	}

	@Override
<<<<<<< HEAD
	public ArrayList<Order> select(String k) throws Exception {
		return om.select(k);
	}

=======
	public Order oidmaxselect() throws Exception {
		// TODO Auto-generated method stub
		return om.oidmaxselect();
	}

	@Override
	public Order select_oid(String obj) throws Exception {
		// TODO Auto-generated method stub
		return om.select_oid(obj);
	}


	
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
}
