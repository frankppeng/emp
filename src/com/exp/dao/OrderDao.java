package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.Order;
import com.exp.modle.User;
import com.exp.util.SqlUtil;

public class OrderDao {
	//查询所有订单
	public List QueryAll() {
		String sql = "select * from orders order by order_id desc";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, null);
		return list;
	}

	//根据电话查询订单
/*	public List QueryTel(String orderTel) {
		String sql = "select * from orders where order_sendtel = ? order by order_id desc";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{orderTel+";"});
		if (list.size() == 0) {
			list = SqlUtil.excuteQuery(sql, new Object[]{";"+orderTel});
		}
		if (list.size() == 0) {
			list = SqlUtil.excuteQuery(sql, new Object[]{orderTel});
		}
		return list;
	}
*/	
	//根据电话查询订单
	public List QueryTel(String orderTel) {
		String sql = " SELECT * FROM orders WHERE order_sendtel LIKE '%"+orderTel+"%'  order by order_id desc";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, null);
		return list;
	}
	
	//根据订单编号查询订单
	public Order QueryId(String orderid) {
		System.out.println("orderid"+orderid);
		String sql = "select * from orders where order_id = ?";
		ArrayList<HashMap<String, Object>> list = SqlUtil.excuteQuery(sql, new Object[]{orderid});
		Order order = null;
		if (list.size()>0) {
			HashMap map = list.get(0);
			String id = String.valueOf(map.get("order_id"));
			String sendname = String.valueOf(map.get("order_sendname"));
			String sendtel = String.valueOf(map.get("order_sendtel"));
			String senddate = String.valueOf(map.get("order_senddate"));
			String getname = String.valueOf(map.get("order_getname"));
			String gettel = String.valueOf(map.get("order_gettel"));
			String getdate = String.valueOf(map.get("order_getdate"));
			String expprice = String.valueOf(map.get("order_expprice"));
			String sendaddid = String.valueOf(map.get("order_sendaddid"));
			String getaddid = String.valueOf(map.get("order_getaddid"));
			order = new Order(id, sendname, sendtel, senddate, getname, gettel, getdate, expprice, sendaddid, getaddid);
		}
		return order;
	}
	
	//添加订单
	public int Add(Order order) {
		String sql = "insert into orders values (?,?,?,?,?,?,?,?,?,?)";
		int row = SqlUtil.excuteUpdate(sql, new Object[]{
				order.getId(),order.getSendname(),order.getSendtel(),order.getSenddate(),order.getGetname(),
				order.getGettel(),order.getGetdate(),order.getExpprice(),order.getSendaddid(),order.getGetaddid()
		});
		return row;
	}

	//删除
	public void Remove(String id){
		String sql ="delete from orders where order_id = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{id});
	}
	
	//修改
	public int  Edit(Order order){
		String sql ="update orders set order_sendname = ?,order_sendtel = ?,order_senddate = ?,order_getname = ?,order_gettel = ?,order_getdate = ?,order_expprice = ?,order_sendaddid = ?,order_getaddid = ? where order_id = ?";
		return SqlUtil.excuteUpdate(sql, new Object[]{
				order.getSendname(),order.getSendtel(),order.getSenddate(),order.getGetname(),order.getGettel(),
				order.getGetdate(),order.getExpprice(),order.getSendaddid(),order.getGetaddid(),order.getId()
		});
	}
	
}
