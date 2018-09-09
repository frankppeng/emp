package com.exp.service;

import com.exp.dao.LoginDao;
import com.exp.modle.Login;

public class TestLoginService {
	LoginDao loginDao = new LoginDao();
	
	public Login Query(String account){
		return loginDao.Query(account);
	}
	
	public int Add(Login login){
		int row = loginDao.Add(login);
		System.out.println(row);
		return row;
	}
	
	public int Edit(Login login){
		return loginDao.Edit(login);
	}
	
	public int Remove(String account){
		return loginDao.Remove(account);
	}
}
