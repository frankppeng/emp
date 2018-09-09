package com.exp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.Order;
import com.exp.service.LogisticsService;
import com.exp.service.OrderService;

@WebServlet("/front/logistics/query.jhtml")
public class FrontLogisticsQueryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		try {
			//订单详情
			OrderService os = new OrderService();
			Order order = os.QueryId(orderId);
			//物流详情
			LogisticsService ls = new LogisticsService();
			List list =  ls.QueryOrderId(orderId);
			if (list.size()>0) {
				HttpSession session = request.getSession();
				session.setAttribute("log", list);
			}
		} catch (Exception e) {
			System.out.println("出现异常");
		}
	}

}
