package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.User;
import com.exp.util.SqlUtil;

public class UserDao {
	//查询
	public List QueryAll() {
		String sql = "select * from USERS";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, null);
		return list;
	}

	public User QueryAccountAndPass(String accout,String userpass) {
		String sql = "select * from users where user_account = ? and user_pass = ?";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{accout,userpass});
		User user= null;
		if (list.size()>0) {
			HashMap map = list.get(0);
			String name = String.valueOf(map.get("user_name"));
			String account = String.valueOf(map.get("user_account"));
			String pass = String.valueOf(map.get("user_pass"));
			String tel = String.valueOf(map.get("user_tel"));
			String email = String.valueOf(map.get("user_email"));
			String sex = String.valueOf(map.get("user_sex"));
			String idcard = String.valueOf(map.get("user_idcard"));
			user = new User(name, account, pass, tel, email, sex, idcard);
		}
		return user;
	}
	
	//添加
	public void Add(User user){
		String sql ="insert into users values (?,?,?,?,?,?,?)";
		SqlUtil.excuteUpdate(sql, new Object[]{user.getName(),user.getAccount(),user.getPass(),user.getTel(),user.getEmail(),user.getSex(),user.getIdcard()});
	}
	//删除
	public void Remove(String account){
		String sql ="delete from users where user_account = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{account});
	}
	//修改
	public void Edit(User user){
		String sql ="update users set user_name = ?,user_pass = ?,user_tel = ?,user_email = ?,user_sex = ?,user_idcard = ? where user_account = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{user.getName(),user.getPass(),user.getTel(),user.getEmail(),user.getSex(),user.getIdcard(),user.getAccount()});
	}
}
