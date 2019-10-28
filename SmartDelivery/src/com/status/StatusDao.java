package com.status;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.OrDependenciesDao;
import com.mapper.StatusMapper;
import com.vo.Status;

@Repository("sdao")
public class StatusDao implements OrDependenciesDao<String, Status> {

	@Autowired(required=true)
	StatusMapper sm;

	@Override
	public void insert(Status v) throws Exception {
		sm.insert(v);
		
	}

	@Override
	public void update(Status v) throws Exception {
		sm.update(v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		sm.delete(k);
		
	}

	@Override
	public ArrayList<Status> select(String k) throws Exception {
		
		return sm.select(k);
	}

	@Override
	public ArrayList<Status> select() throws Exception {
		// TODO Auto-generated method stub
		return sm.selectall();
	}

	@Override
	public Status oidmaxselect() throws Exception {
		// TODO Auto-generated method stub
		return sm.oidmaxselect();
	}

	@Override
	public Status select_oid(String obj) throws Exception {
		// TODO Auto-generated method stub
		return sm.select_oid(obj);
	}
	


	
}
