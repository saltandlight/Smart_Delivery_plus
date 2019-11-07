package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.DependenciesBiz;
import com.frame.DependenciesDao;
import com.vo.Product;

@Service("pbiz")
public class ProductBiz implements DependenciesBiz<String, Product> {

	@Resource(name="pdao")
	DependenciesDao<String, Product> dao;
	
	@Override
	public void register(Product v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(Product v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public Product get(String k) throws Exception {
		return dao.select(k);
	}
	
	@Override
	public Product pidmaxselect() throws Exception{
		return dao.pidmaxselect();
	}
	
	@Override
	public ArrayList<Product> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<Product> selectbest() throws Exception {
		return dao.selectbest();
	}

}
