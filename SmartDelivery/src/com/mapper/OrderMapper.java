package com.mapper;

import java.util.ArrayList;

import com.vo.Order;

public interface OrderMapper {
	public void insert(Order obj);
	public void delete(String obj);
	public void update(Order obj);
	public ArrayList<Order> select(String obj);
	public ArrayList<Order> selectall();
}
