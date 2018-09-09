package com.exp.service;

import java.util.List;

import com.exp.dao.LogisticsDao;

public class LogisticsService {
	LogisticsDao logDao = new LogisticsDao();
	
	public List QueryAll(){
		return logDao.Query();
	}

	public List QueryOrderId(String orderId) {
		return logDao.QueryOrderId(orderId);
	}

}
