package com.status;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.StDependenciesBiz;
import com.frame.StDependenciesDao;
import com.vo.Status;


@Service("sbiz")
public class StatusBiz implements StDependenciesBiz<String, Status> {

	@Resource(name="sdao")
	StDependenciesDao<String, Status> sdao;

	@Override
	public void register(Status v) throws Exception {
		
		sdao.insert(v);
		
	}

	@Override
	public void modify(Status v) throws Exception {

		sdao.update(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		sdao.delete(k);
		
	}

	@Override
	public ArrayList<Status> get() throws Exception {
		// TODO Auto-generated method stub
		return sdao.select();
	}


	@Override
	public Status get(String k) throws Exception {
		// TODO Auto-generated method stub
		return sdao.select(k);
	}

	@Override
	public Status selectpos(String k) throws Exception {
		// TODO Auto-generated method stub
		return sdao.selectpos(k);
	}

	
	
	
}
