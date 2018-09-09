package com.exp.service;

import java.util.List;

import com.exp.dao.CourDao;
import com.exp.modle.Cour;

public class CourService {
	CourDao courDao = new CourDao();
	//query client
	public List Query(){
		List list = courDao.QueryAll();
		return list;
	}
	
	public Cour Query(String sendaddid){
		Cour cour = courDao.Querysendaddid(sendaddid);
		return cour;
	}
	
	public Cour QueryLoginAccountAndPass(String accout,String pass){
		Cour court = courDao.QueryAccountAndPass(accout, pass);
		return court;
	}
	//add client
	public int Add(Cour cour){
		int result = courDao.Add(cour);
		return result;
	}
	//romove client
	public void Remove(String account){
		courDao.Remove(account);
	}
	//edit client
	public int Edit(Cour cour){
		return courDao.Edit(cour);
	}
}
