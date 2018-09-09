package com.exp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.Login;
import com.exp.modle.User;
import com.exp.service.TestLoginService;
import com.exp.service.UserService;

@WebServlet("/back/backlogin.jhtml")
public class BackUserLoginServlet extends HttpServlet{
	
	User user = null;
	Login login = null;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取参数 userid 和 密码
		String bankUserId = request.getParameter("name");
		String bankPass = request.getParameter("password");
		
		//处理业务
		System.out.println("name："+bankUserId+"\tpassword："+bankPass);
		UserService us = new UserService();
		boolean bool = false;
		try {
			user = us.QueryLoginAccountAndPass(bankUserId, bankPass);
			if (user == null) {
				request.setAttribute("backloginerror", "用户名或密码错误");
				//添加跳转错误页面
				request.getRequestDispatcher("/login/backlogin.jsp").forward(request, response);
			}else {
				HttpSession se = request.getSession();
				se.setAttribute("backlogin", user);
				
				TestLoginService tls = new TestLoginService();
				login = tls.Query(user.getAccount());
				if (login == null) {//未查找到用户
					System.out.println("未找到");
					login = new  Login(user.getAccount(), se.getId(), "1", "");
					int row = tls.Add(login);//创建用户，并且改为在线
					if (row == 1) {
						System.out.println("创建成功");
						//开始登录
						bool = true;
					}
				}else if(login.getStatus().equals("0")){//查到用户，未登录
					System.out.println("未登录");
					login = new  Login(user.getAccount(), se.getId(), "1", "");
					int row = tls.Edit(login);//创建用户，并且改为在线
					if (row == 1) {
						System.out.println("更改成功");
						//登录
						bool = true;
					}
					
				}
				
				if (bool) {
					System.out.println("登录成功");
					String url="/static/back/backmain.html";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}else {
//					String url="/static/back/backmain.html";
//					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//					dispatcher.forward(request, response);
					request.setAttribute("backloginerror", "用户已在线");
					request.getRequestDispatcher("/login/backlogin.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			System.out.println("登录异常");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

	}

	public void remove(){
		TestLoginService tls = new TestLoginService();
		try {
			int row = tls.Remove("admin");			
			if (row == 1) {
				System.out.println("移除成功");
			}
		} catch (Exception e) {
			System.out.println("删除失败");
		}
	}
	
}
