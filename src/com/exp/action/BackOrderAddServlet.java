package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Message;
import com.exp.modle.Order;
import com.exp.service.OrderService;
import com.google.gson.Gson;

@WebServlet("/back/order/add.jhtml")
public class BackOrderAddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sendname = request.getParameter("order_sendname");
		String sendtel = request.getParameter("order_sendtel");
		String senddate = request.getParameter("order_senddate");
		String getname = request.getParameter("order_getname");
		String gettel = request.getParameter("order_gettel");
		String getdate = request.getParameter("order_getdate");
		String expprice = request.getParameter("order_expprice");
		String sendaddid = request.getParameter("order_sendaddid");
		String getaddid = request.getParameter("order_getaddid");
		Order order = new Order("0", sendname, sendtel, senddate, getname,gettel, getdate, expprice, sendaddid, getaddid);
		System.out.println(order.toString());

		Message msg = null;
		Gson gson = new Gson();
		String json = null;

		OrderService es = new OrderService();
		int result;

		try {
			result = es.Add(order);
			if (result == 1) {
				msg = new Message("200", "成功", "");
			} else {
				msg = new Message("210", "失败", "");
			}
		} catch (Exception e) {
			msg = new Message("250", "失败", "");
		}

		json = gson.toJson(msg);

		response.getWriter().print(json);
		response.getWriter().close();
	}

}
