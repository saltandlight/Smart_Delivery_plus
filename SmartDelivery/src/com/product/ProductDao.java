package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.Dao;

import com.mapper.ProductMapper;
import com.vo.Product;



@Service("pdao")
public class ProductDao implements Dao<String, Product> {
	
	@Autowired(required=true)
	ProductMapper pm;
	

	@Override
	public void insert(Product v) throws Exception {
		
		pm.insert(v);
	}

	@Override
	public void update(Product v) throws Exception {
		
		pm.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
		
	}

	@Override
	public Product select(String k) throws Exception {
		
		return pm.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		
		return pm.selectall();
	}

}
