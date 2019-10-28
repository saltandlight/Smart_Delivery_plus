package com.status;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.OrDependenciesBiz;
import com.frame.OrDependenciesDao;
import com.vo.Status;


@Service("sbiz")
public class StatusBiz implements OrDependenciesBiz<String, Status> {

	@Resource(name="sdao")
	OrDependenciesDao<String, Status> sdao;

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
	public ArrayList<Status> get(String k) throws Exception {
		
		return sdao.select(k);
	}

	@Override
	public ArrayList<Status> get() throws Exception {
		// TODO Auto-generated method stub
		return sdao.select();
	}

	@Override
	public Status oidmaxselect() throws Exception {
		// TODO Auto-generated method stub
		return sdao.oidmaxselect();
	}

	@Override
	public Status select_oid(String obj) throws Exception {
		// TODO Auto-generated method stub
		return sdao.select_oid(obj);
	}

	
	
	
}
