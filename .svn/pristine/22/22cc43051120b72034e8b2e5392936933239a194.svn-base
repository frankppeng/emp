package com.exp.service;

import java.util.List;

import com.exp.dao.UserDao;
import com.exp.modle.User;

public class UserService {
	UserDao userDao = new UserDao();
	//query user
	public List Query(){
		List list = userDao.QueryAll();
		return list;
	}
	public User QueryLoginAccountAndPass(String accout,String pass){
		User user = userDao.QueryAccountAndPass(accout, pass);
		return user;
	}
	//add user
	public void Add(User user){
		userDao.Add(user);
	}
	//romove user
	public void Remove(String account){
		userDao.Remove(account);
	}
	//edit user
	public void Edit(User user){
		userDao.Edit(user);
	}
}
