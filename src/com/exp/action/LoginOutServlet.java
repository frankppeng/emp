package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/out.jhtml")
public class LoginOutServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("B");
		HttpSession se = request.getSession(false);
		if (se != null) {
			se.invalidate();
		}
		System.out.println("exit");
		response.sendRedirect("/exp/login/backlogin.jsp");
		System.out.println("BB");
		BackUserLoginServlet buls = new BackUserLoginServlet();
		buls.remove();
	}

}
