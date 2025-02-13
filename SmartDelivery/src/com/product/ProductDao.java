package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.DependenciesDao;
import com.mapper.ProductMapper;
import com.vo.Product;

@Repository("pdao")
public class ProductDao implements DependenciesDao<String, Product> {

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
	public Product pidmaxselect() throws Exception{
		return pm.pidmaxselect();
	}
	
	@Override
	public ArrayList<Product> select() throws Exception {
		return pm.selectall();
	}

	@Override
	public ArrayList<Product> selectbest() throws Exception {
		return pm.selectbest();
	}

	
}
