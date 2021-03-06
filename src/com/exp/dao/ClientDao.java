package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.Client;
import com.exp.modle.User;
import com.exp.util.SqlUtil;

public class ClientDao {
	//查询
	public List QueryAll() {
		String sql = "select * from client order by client_account desc";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, null);
		return list;
	}

	public Client QueryAccountAndPass(String accout,String userpass) {
		String sql = "select * from client where client_account = ? and client_pass = ?";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{accout,userpass});
		Client client= null;
		if (list.size()>0) {
			HashMap map = list.get(0);
			//oracle
			String name = String.valueOf(map.get("client_name"));
			String account = String.valueOf(map.get("client_account"));
			String pass = String.valueOf(map.get("client_pass"));
			String tel = String.valueOf(map.get("client_tel"));
			String idcard = String.valueOf(map.get("client_idcard"));
			String sex = String.valueOf(map.get("client_sex"));
			String addressid = String.valueOf(map.get("client_addressid"));
			String email = String.valueOf(map.get("client_email"));
			client = new Client(name, account, pass, tel, idcard, sex, addressid, email);
		}
		return client;
	}

	//添加
	public int Add(Client client){
		String sql ="insert into client values (?,?,?,?,?,?,?,?)";
		int result = SqlUtil.excuteUpdate(sql, new Object[]{
				client.getName(),"0",client.getPass(),client.getTel()==null?"0":client.getTel(),
				client.getIdcard()==null?"0":client.getIdcard(),client.getSex(),
				client.getAddressid()==null?"0":client.getAddressid(),client.getEmail()});
		return result;
	}
	//删除
	public void Remove(String account){
		String sql ="delete from client where client_account = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{account});
	}
	//修改全部数据
	public int Edit(Client client){
		String sql ="update client set client_name = ?,client_pass = ?,client_tel = ?,client_idcard = ?,client_sex = ?,client_addressid = ?,client_email = ? where client_account = ?";
		int row = SqlUtil.excuteUpdate(sql, new Object[]{client.getName(),client.getPass(),client.getTel(),client.getIdcard(),client.getSex(),client.getAddressid(),client.getEmail(),client.getAccount()});
		return row;
	}
	
	//模糊查询
	public List queryList(String name) {
		String sql="select * from client c where concat(c.client_name,c.client_sex,c.client_addressid,c.client_email) like '%"+name+"%'";
		ArrayList<HashMap<String,Object>>  list  = SqlUtil.excuteQuery(sql, null);
		SqlUtil.close();
		return list;
	}

}
