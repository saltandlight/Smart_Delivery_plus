package com.frame;

import java.util.ArrayList;

import com.vo.Order;

public interface OrDependenciesDao<K,V> {
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	public ArrayList<V> select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
	//Specialized
	public V oidmaxselect() throws Exception;
	public V select_oid(String obj) throws Exception;
	public V select_rec(String obj) throws Exception;
}
