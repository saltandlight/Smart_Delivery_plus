package com.frame;

import java.util.ArrayList;

<<<<<<< HEAD
public interface OrDependenciesDao<K, V> {
=======
public interface OrDependenciesDao<K,V> {
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	public ArrayList<V> select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
<<<<<<< HEAD
=======
	//Specialized
	public V oidmaxselect() throws Exception;
	public V select_oid(String obj) throws Exception;
>>>>>>> e165b8831c631c94a980f9cd2c6e893d9b378c0a
}
