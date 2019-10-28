package com.mapper;

import java.util.ArrayList;

import com.vo.Delivery;

public interface DeliveryMapper {
	public void insert(Delivery obj);
	public void delete(String obj);
	public void update(Delivery obj);
	public Delivery select(String obj);	
	public ArrayList<Delivery> selectall();
}
