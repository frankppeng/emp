package com.exp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Order;
import com.exp.service.OrderService;

@WebServlet("/front/order/query.jhtml")
public class FrontOrderQueryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		String sendtel = request.getParameter("sendtel");
		OrderService os = new OrderService();
		try {
			if (id.length() != 0) {
				Order order = os.QueryId(id);
				if (order == null) {
					request.setAttribute("ordererror", "请填写正确的单号");
					request.getRequestDispatcher("/static/front/querynull.jsp").forward(request, response);
				}else {
					System.out.println(order.toString());
					request.setAttribute("order", order);
					request.getRequestDispatcher("/static/front/queryid.jsp").forward(request, response);
				}
			}else if (sendtel.length() != 0) {
				List list = os.QueryTel(sendtel);//error
				if (list.size()>0) {
					System.out.println("list:"+list.toString());
					request.setAttribute("order", list);
					request.getRequestDispatcher("/static/front/querytel.jsp").forward(request, response);
				} else {
					request.setAttribute("ordererror", "没有你的快递");
					request.getRequestDispatcher("/static/front/querynull.jsp").forward(request, response);
				}
			}else {
				return;
			}			
		} catch (Exception e) {
			request.setAttribute("ordererror", "系统正在升级中");
			request.getRequestDispatcher("/static/front/querynull.jsp").forward(request, response);
		}
	}

}
