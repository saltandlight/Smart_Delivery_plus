package com.mapper;

import java.util.ArrayList;

import com.vo.Order;
import com.vo.Product;

public interface OrderMapper {
	public void insert(Order obj);
	public void delete(String obj);
	public void update(Order obj);
	public ArrayList<Order> select(String obj);
	public Order select_oid(String obj);
	public ArrayList<Order> selectall();
	public Order oidmaxselect();
	public Order recmaxselect(String obj);
}
