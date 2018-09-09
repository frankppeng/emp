package com.exp.service;

import java.util.List;

import com.exp.dao.OrderDao;
import com.exp.modle.Order;

public class OrderService {
	OrderDao orderDao = new OrderDao();
	//query order
	public List Query(){//by orderid
		List list = orderDao.QueryAll();
		return list;
	}
	public List QueryTel(String orderTel){//by orderid
		List list = orderDao.QueryTel(orderTel);
		return list;
	}
	public Order QueryId(String orderid){//by orderid
		Order order = orderDao.QueryId(orderid);
		return order;
	}
	//add order
	public int Add(Order order){
		int row = orderDao.Add(order);
		return row;
	}
	//romove order
	public void Remove(String orderid){
		orderDao.Remove(orderid);
	}
	//edit order
	public int Edit(Order order){
		return orderDao.Edit(order);
	}
}
