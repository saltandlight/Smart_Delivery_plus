package com.status;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.StDependenciesDao;
import com.mapper.StatusMapper;
import com.vo.Status;

@Repository("sdao")
public class StatusDao implements StDependenciesDao<String, Status> {

	@Autowired(required=true)
	StatusMapper sm;

	@Override
	public void insert(Status v) throws Exception {
		// TODO Auto-generated method stub
		sm.insert(v);
	}

	@Override
	public void update(Status v) throws Exception {
		// TODO Auto-generated method stub
		sm.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		sm.delete(k);
	}

	@Override
	public Status select(String k) throws Exception {
		// TODO Auto-generated method stub
		return sm.select(k);
	}

	@Override
	public ArrayList<Status> select() throws Exception {
		// TODO Auto-generated method stub
		return sm.selectall(); 
	}

	@Override
	public Status selectpos(String k) throws Exception {
		// TODO Auto-generated method stub
		return sm.selectpos(k);
	}

	


	
}
