package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
public interface OrDependenciesBiz<K, V> {
=======
import com.vo.Order;

public interface OrDependenciesBiz<K,V> {
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	@Transactional
	public void register(V v) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	public ArrayList<V> get(K k) throws Exception;
	public ArrayList<V> get() throws Exception;
<<<<<<< HEAD
	
=======
	//Specialized
	public V oidmaxselect() throws Exception;
	public V select_oid(String obj) throws Exception;
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
}
