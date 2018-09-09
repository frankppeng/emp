package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.Logistics;
import com.exp.util.SqlUtil;

public class LogisticsDao {
	
	public List Query() {
		String sql = "select * from logistics order by log_id desc";
		ArrayList<HashMap<String, Object>> list =  SqlUtil.excuteQuery(sql, null);
		return list;
	}

	public List QueryOrderId(String orderId) {
		String sql = "select * from logistics where order_id = ? order by log_id desc";
		ArrayList<HashMap<String, Object>> list =  SqlUtil.excuteQuery(sql, new Object[]{orderId});
		return list;
	}
	
	public int Add(Logistics log){
		String sql = "insert into logistics values (?,?,?,?,?,?)";
		return SqlUtil.excuteUpdate(sql, new Object[]{"0",log.getOrderId(),log.getCourId(),log.getLogAddress(),log.getLogDate(),log.getLogStatus()});
	}
	
	public int Edit(Logistics log){
		String sql = "update logistics set order_id = ?,cour_id = ?,log_address = ?,log_date = ?,log_status = ? where log_id = ?";
		return  SqlUtil.excuteUpdate(sql, new Object[]{log.getOrderId(),log.getCourId(),log.getLogAddress(),log.getLogDate(),log.getLogStatus(),log.getLogId()});
	}
	
	public void Remove(String LogId){
		String sql = "delete from logistics where log_id = ?";
		SqlUtil.excuteUpdate(sql, new Object[]{LogId});
	}

}