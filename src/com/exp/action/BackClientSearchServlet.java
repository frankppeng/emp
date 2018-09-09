package com.exp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.service.ClientService;
import com.exp.util.BeanJsonUtil;

@WebServlet("/backclientsearch")
public class BackClientSearchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");  
         response.setCharacterEncoding("UTF-8");  
        //获取值
		String name =request.getParameter("name");
		PrintWriter out = response.getWriter();  
		//client
		System.out.println(name);
		
		ClientService cs = new ClientService();
		List list = cs.queryList(name);
		BeanJsonUtil.writeJson(response, list);
	}
}
