package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.Client;
import com.exp.modle.Message;
import com.exp.modle.User;
import com.exp.service.ClientService;
import com.google.gson.Gson;

@WebServlet("/front/register.jhtml")
public class FrontClientRegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("register");
		//获取参数Client
		String frontClientName = request.getParameter("name");
		String frontPass = request.getParameter("password");
		String frontTel = request.getParameter("tel");
		String frontIdcard = request.getParameter("idcard");
		String frontSex = request.getParameter("sex");
		String frontEmail = request.getParameter("email");
		
		System.out.println("name:"+frontClientName+"\tpassword:"+frontPass);
		Client client = new Client(frontClientName, null, frontPass, frontTel, frontIdcard, frontSex, null, frontEmail);
		System.out.println(client.toString());		
		
		Message msg = null;
		ClientService cs = new ClientService();
		try {
			int result = cs.Add(client);
			if (result == 1) {
				msg = new Message("200", "注册成功","");
				System.out.println("200");
			} else {
				msg = new Message("210", "注册失败","");
				System.out.println("210");
			}
		} catch (Exception e) {
			msg = new Message("250", "连接异常","");
			System.out.println("250");
		}
		Gson gson = new Gson();
		String json = gson.toJson(msg);
		response.setContentType("text/json");
		
		response.getWriter().println(json);
		response.getWriter().close();
	}
}
