package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.Client;
import com.exp.modle.Cour;
import com.exp.modle.User;
import com.exp.util.SqlUtil;

public class CourDao {
	//查询
	public List QueryAll() {
		String sql = "select * from courier order by cour_account desc";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, null);
		return list;
	}

	public Cour QueryAccountAndPass(String accout,String userpass) {
		String sql = "select * from courier where cour_account = ? and cour_pass = ?";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{accout,userpass});
		Cour cour= null;
		if (list.size()>0) {
			HashMap map = list.get(0);
			String account = String.valueOf(map.get("cour_account"));
			String name = String.valueOf(map.get("cour_name"));
			String pass = String.valueOf(map.get("cour_pass"));
			String tel = String.valueOf(map.get("cour_tel"));
			String email = String.valueOf(map.get("cour_email"));
			String idcard = String.valueOf(map.get("cour_idcard"));
			String addressid = String.valueOf(map.get("cour_addressid"));
			cour = new Cour(account, name, pass, tel, email, idcard, addressid);
		}
		return cour;
	}
	
	public Cour Querysendaddid(String sendaddid) {
		List listcour = QueryAll();
		Cour cour= null;
		for (int i = 0; i < listcour.size(); i++) {
			HashMap map = (HashMap) listcour.get(i);
			String addressid = String.valueOf(map.get("cour_addressid"));
			if (sendaddid.indexOf(addressid) != -1) {
				String account = String.valueOf(map.get("cour_account"));
				String name = String.valueOf(map.get("cour_name"));
				String pass = String.valueOf(map.get("cour_pass"));
				String tel = String.valueOf(map.get("cour_tel"));
				String email = String.valueOf(map.get("cour_email"));
				String idcard = String.valueOf(map.get("cour_idcard"));
				String cour_addressid = String.valueOf(map.get("cour_addressid"));
				cour = new Cour(account, name, pass, tel, email, idcard, cour_addressid);
			}
		}
		return cour;
	}

	//添加
	public int Add(Cour cour){
		String sql ="insert into courier values (?,?,?,?,?,?,?)";
		int result = SqlUtil.excuteUpdate(sql, new Object[]{
				"0",cour.getName(),cour.getPass(),cour.getTel(),cour.getEmail(),cour.getIdcard(),cour.getAddressid()
		});
		return result;
	}
	//删除
	public void Remove(String account){
		String sql ="delete from courier where cour_account = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{account});
	}
	//修改全部数据
	public int Edit(Cour cour){
		String sql ="update courier set cour_name = ?,cour_pass = ?,cour_tel = ?,cour_email = ?,cour_idcard = ?,cour_addressid = ? where cour_account = ?";
		return SqlUtil.excuteUpdate(sql, new Object[]{cour.getName(),cour.getPass(),cour.getTel(),cour.getEmail(),cour.getIdcard(),cour.getAddressid(),cour.getAccount()});
	}
}
