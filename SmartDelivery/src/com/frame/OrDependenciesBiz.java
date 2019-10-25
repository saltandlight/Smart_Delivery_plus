package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.vo.Order;

public interface OrDependenciesBiz<K,V> {
	@Transactional
	public void register(V v) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	public ArrayList<V> get(K k) throws Exception;
	public ArrayList<V> get() throws Exception;
	//Specialized
	public V oidmaxselect() throws Exception;
	public V select_oid(String obj) throws Exception;
	public V select_rec(String obj) throws Exception;
}
