package com.exp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.User;

public class BackLoginFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("backlogin");
		System.out.println("user:"+user);
		if (user != null) {
			System.out.println("跳转后台主页面");
			chain.doFilter(request, response);
		} else {
			System.out.println("拦截,回到登录界面");
			response.sendRedirect("/exp/login/backlogin.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
