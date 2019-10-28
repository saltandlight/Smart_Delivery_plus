package com.mapper;

import java.util.ArrayList;

import com.vo.Customer;

public interface CustomerMapper {
	public void insert(Customer obj);
	public void delete(String obj);
	public void update(Customer obj);
	public Customer select(String obj);
	public ArrayList<Customer> selectall();
}
