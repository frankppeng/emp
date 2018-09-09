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

@WebServlet("/front/login.jhtml")
public class FrontClientLoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数 userid 和 密码
		String frontClientAccount = request.getParameter("account");
		String frontClientPass = request.getParameter("password");
		System.out.println("account:"+frontClientAccount+"\tpassword:"+frontClientPass);
		Message msg = null;
		ClientService cs = new ClientService();
		try {
			Client client = cs.QueryLoginAccountAndPass(frontClientAccount, frontClientPass);
			if (client == null) {
				msg = new Message("210", "用户名或密码错误","");
			} else {
				System.out.println(client.toString());
				HttpSession session = request.getSession();
				session.setAttribute("frontlogin", client);
				msg = new Message("200", "登录成功","");
			}
		} catch (Exception e) {
			msg = new Message("250", "登录异常","");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(msg);
		response.setContentType("text/json");
		
		response.getWriter().println(json);
		response.getWriter().close();
		System.out.println("Login end");
	}
}
