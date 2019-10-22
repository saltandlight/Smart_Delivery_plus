package com.frame;

import java.util.ArrayList;

public interface OrDependenciesDao<K, V> {
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	public ArrayList<V> select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
}
