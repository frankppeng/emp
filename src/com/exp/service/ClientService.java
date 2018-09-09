package com.exp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.dao.ClientDao;
import com.exp.modle.Client;
import com.exp.modle.PageModel;
import com.exp.util.SqlUtil;

public class ClientService {
	ClientDao clientDao = new ClientDao();
	//query client
	public List Query(){
		List list = clientDao.QueryAll();
		return list;
	}
	public Client QueryLoginAccountAndPass(String accout,String pass){
		Client client = clientDao.QueryAccountAndPass(accout, pass);
		return client;
	}
	//add client
	public int Add(Client client){
		int result = clientDao.Add(client);
		return result;
	}
	//romove client
	public void Remove(String account){
		clientDao.Remove(account);
	}
	//edit client
	public int Edit(Client client){
		return clientDao.Edit(client);
	}
	//search
	public List queryList(String name) {
		return clientDao.queryList(name);
	}
	//分页
	public PageModel  queryPageList(String page,String pageSize ){
		
		String sql="select * from client";
		
		PageModel  pageModel=new PageModel(sql,page,pageSize);
		
		List list  = SqlUtil.excuteQuery(pageModel.toMysqlSql(), null);
		
		pageModel.setList(list);
		
		ArrayList<HashMap<String,Object>>  myList=  SqlUtil.excuteQuery(pageModel.toCountSql(), null);
		if(myList.size()>0){
			HashMap  map  =myList.get(0);
			Integer  count =Integer.valueOf(String.valueOf(map.get("count")));
			//把条数放到模型中1
			pageModel.setTotal(count);
		}
		return pageModel;
	}

}

