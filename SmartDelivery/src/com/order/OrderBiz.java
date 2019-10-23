package com.order;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.OrDependenciesBiz;
import com.frame.OrDependenciesDao;
import com.vo.Order;
import com.vo.Product;

@Service("obiz")
public class OrderBiz implements OrDependenciesBiz<String, Order> {

	@Resource(name="odao")
	OrDependenciesDao<String, Order> dao;

	@Override
	public void register(Order v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(Order v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public ArrayList<Order> get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<Order> get() throws Exception {
		return dao.select();
	}
	
	
}
