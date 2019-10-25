package com.order;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.OrDependenciesBiz;
import com.frame.OrDependenciesDao;
import com.vo.Order;
<<<<<<< HEAD
=======
import com.vo.Product;
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a

@Service("obiz")
public class OrderBiz implements OrDependenciesBiz<String, Order> {

	@Resource(name="odao")
<<<<<<< HEAD
	OrDependenciesDao<String, Order> odao;
	
	@Override
	public void register(Order v) throws Exception {
		odao.insert(v);
=======
	OrDependenciesDao<String, Order> dao;

	@Override
	public void register(Order v) throws Exception {
		dao.insert(v);
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	}

	@Override
	public void modify(Order v) throws Exception {
<<<<<<< HEAD
		odao.update(v);
=======
		dao.update(v);
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	}

	@Override
	public void remove(String k) throws Exception {
<<<<<<< HEAD
		odao.delete(k);
=======
		dao.delete(k);
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	}

	@Override
	public ArrayList<Order> get(String k) throws Exception {
<<<<<<< HEAD
		return odao.select(k);
=======
		return dao.select(k);
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	}

	@Override
	public ArrayList<Order> get() throws Exception {
<<<<<<< HEAD
		return odao.select();
	}

=======
		return dao.select();
	}

	@Override
	public Order oidmaxselect() throws Exception {
		return dao.oidmaxselect();
	}

	@Override
	public Order select_oid(String obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.select_oid(obj);
	}
	
	
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
}
