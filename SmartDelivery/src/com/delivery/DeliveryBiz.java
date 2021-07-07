package com.delivery;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Delivery;
import com.vo.Product;

@Service("dbiz")
public class DeliveryBiz implements Biz<String, Delivery> {

	@Resource(name="ddao")
	Dao<String, Delivery> dao;
	
	@Override
	public void register(Delivery v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(Delivery v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public Delivery get(String k) throws Exception {
		return dao.select(k);
	}
	

	@Override
	public ArrayList<Delivery> get() throws Exception {
		return dao.select();
	}

}
