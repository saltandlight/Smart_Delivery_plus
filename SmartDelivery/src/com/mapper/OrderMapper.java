package com.mapper;

import java.util.ArrayList;

import com.vo.Order;
<<<<<<< HEAD
=======
import com.vo.Product;
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a

public interface OrderMapper {
	public void insert(Order obj);
	public void delete(String obj);
	public void update(Order obj);
	public ArrayList<Order> select(String obj);
<<<<<<< HEAD
	public ArrayList<Order> selectall();
	
=======
	public Order select_oid(String obj);
	public ArrayList<Order> selectall();
	public Order oidmaxselect();
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
}
