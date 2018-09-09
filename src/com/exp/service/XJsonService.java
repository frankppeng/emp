package com.exp.service;

import java.util.ArrayList;

import com.exp.dao.XJsonDao;
import com.exp.modle.XY;




public class XJsonService {
public ArrayList<XY> xjsonS(){
	ArrayList<XY> array=null;
	XJsonDao xDao=new XJsonDao();
	array=xDao.xjson();
	return array;
}
}
