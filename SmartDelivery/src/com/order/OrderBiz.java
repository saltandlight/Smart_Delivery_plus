package com.order;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.OrDependenciesBiz;
import com.frame.OrDependenciesDao;
import com.vo.Order;

@Service("obiz")
public class OrderBiz implements OrDependenciesBiz<String, Order> {

	@Resource(name="odao")
	OrDependenciesDao<String, Order> odao;
	
	@Override
	public void register(Order v) throws Exception {
		odao.insert(v);
	}

	@Override
	public void modify(Order v) throws Exception {
		odao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		odao.delete(k);
	}

	@Override
	public ArrayList<Order> get(String k) throws Exception {
		return odao.select(k);
	}

	@Override
	public ArrayList<Order> get() throws Exception {
		return odao.select();
	}

}
