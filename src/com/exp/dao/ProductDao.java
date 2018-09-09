package com.exp.dao;

import java.util.List;

import com.exp.modle.Product;
import com.exp.util.SqlUtil;

public class ProductDao {
	
	public List Query(){
		String sql = "select * from product";
		return SqlUtil.excuteQuery(sql, null);
	}
	
	public int Edit(Product pro){
		String sql = "update product set proNum = ?,proName = ? where proName = ?";
		return SqlUtil.excuteUpdate(sql, new Object[]{pro.getProNum(),pro.getProName(),pro.getDetails()});
	}
	
}
