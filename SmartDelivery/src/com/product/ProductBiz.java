package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Product;

@Service("pbiz")
public class ProductBiz implements Biz<String, Product> {

	@Resource(name="pdao")
	Dao<String, Product> dao;
	
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
	public ArrayList<Product> get() throws Exception {
		return dao.select();
	}

}
