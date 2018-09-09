package com.exp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exp.modle.XY;
import com.exp.util.SqlUtil;




public class XJsonDao {
public ArrayList<XY> xjson(){
	ArrayList<HashMap<String, Object>> list=null;
	String sql="select proName,proNum from product where proNum>100";
	list =SqlUtil.excuteQuery(sql, null);
	ArrayList<XY> array=new ArrayList<XY>();
	  for(HashMap map:list){
			 XY barbean= new XY();
			barbean.setName(String.valueOf(map.get("proName")));
			barbean.setNum(String.valueOf(map.get("proNum")));
			array.add(barbean);
		  }
	return array;
}
}
