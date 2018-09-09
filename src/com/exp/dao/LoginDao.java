package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.exp.modle.Login;
import com.exp.modle.User;
import com.exp.util.SqlUtil;

public class LoginDao {
	//查询
	public Login Query(String account) {
		String sql = "select * from login where account = ?";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{account});
		
		Login login= null;
		if (list.size()>0) {
			HashMap map = list.get(0);
			String Account = String.valueOf(map.get("account"));
			String session = String.valueOf(map.get("session"));
			String status = String.valueOf(map.get("status"));
			String details = String.valueOf(map.get("details"));
			login = new Login(Account, session, status, details);
		}
		return login;
	}
	
	//添加
	public int Add(Login login){
		String sql ="insert into login values (?,?,?,?)";
		return SqlUtil.excuteUpdate(sql, new Object[]{login.getAccount(),login.getSession(),login.getStatus(),login.getStatus()==null?"0":login.getStatus()});
	}
	//修改
	public int Edit(Login login){
		String sql ="update login set session = ?,status = ?,details = ? where account = ?";
		int row = SqlUtil.excuteUpdate(sql, new Object[]{login.getSession(),login.getStatus(),login.getStatus()==null?"0":login.getStatus(),login.getAccount()});
		return row;
	}
	//添加
	public int Remove(String account){
		String sql ="delete from login where account = ?";
		return SqlUtil.excuteUpdate(sql, new Object[]{account});
	}

}
