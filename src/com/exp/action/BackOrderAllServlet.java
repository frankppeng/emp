package com.exp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.service.OrderService;
import com.google.gson.Gson;

@WebServlet("/back/order.jhtml")
public class BackOrderAllServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService cs = new OrderService();
		List list = cs.Query();
		System.out.println(list.toString());

		Gson gson = new Gson();
		String json = gson.toJson(list);

		response.getWriter().println(json);
		response.getWriter().close();
	}

}
