package com.exp.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.Cour;
import com.exp.modle.Message;
import com.exp.modle.Order;
import com.exp.service.CourService;
import com.exp.service.OrderService;
import com.google.gson.Gson;

@WebServlet("/front/order/add.jhtml")
public class FrontOrderAddServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("add");
		//获取数据
		String sendname = request.getParameter("SenderName");
		String sendtel = request.getParameter("SenderPhone")+";"+request.getParameter("SenderMobile");
		String senddate = request.getParameter("FetchTime");
		String getname = request.getParameter("AcceptName");
		String gettel = request.getParameter("AcceptPhone")+";"+request.getParameter("AcceptMobile");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +3);
		Date now = cal.getTime();
		String getdate = sdf.format(now); 
		String sendaddid = request.getParameter("SenderProCityAres")+request.getParameter("SenderAddress");
		String getaddid = request.getParameter("AcceptProCityArea")+request.getParameter("AcceptAddress");
		String expprice = ((int) (10+Math.random()*(40-10+1)))+"";
		Order order = new Order("0", sendname, sendtel, senddate, getname, gettel, getdate, expprice, sendaddid, getaddid);
		System.out.println(order.toString());
		//处理数据
		OrderService os = new OrderService();
		Message msg = null;
		Gson gson = new Gson();
		try {
			int row = os.Add(order);
			if (row == 1) {
				//成功
				System.out.println("200");
				List list = os.QueryTel(sendtel);
				HashMap map = (HashMap) list.get(0);
				String orderId = String.valueOf(map.get("order_id"));
				order = os.QueryId(orderId);
				System.out.println("订单"+order.toString());
				HttpSession session = request.getSession();
				session.setAttribute("order", order);
				String orderSendAddId = String.valueOf(map.get("order_sendaddid"));
				CourService cs = new CourService();
				Cour cour = cs.Query(orderSendAddId);
				//System.out.println("快递员"+cour.toString());
				session.setAttribute("cour", cour);
				msg = new Message("200", "添加成功",orderId);	
			}else {
				//失败
				msg = new Message("210", "添加失败","");	
			}
		} catch (Exception e) {
			msg = new Message("250", "添加失败","");
		}
		String json = gson.toJson(msg);
		response.getWriter().println(json);
		response.getWriter().close();
	}
}
