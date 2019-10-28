package com.delivery;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.DeliveryMapper;
import com.vo.Delivery;

@Repository("ddao")
public class DeliveryDao implements Dao<String, Delivery> {
	
	@Autowired(required=true)
	DeliveryMapper dm;
	
	
	@Override
	public void insert(Delivery v) throws Exception {
		dm.insert(v);
	}

	@Override
	public void update(Delivery v) throws Exception {
		dm.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		dm.delete(k);
	}

	@Override
	public Delivery select(String k) throws Exception {
		return dm.select(k);
	}

	@Override
	public ArrayList<Delivery> select() throws Exception {
		return dm.selectall();
	}

	
}
