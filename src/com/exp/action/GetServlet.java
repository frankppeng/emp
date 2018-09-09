package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/order/paystatus.jhtml")
public class GetServlet extends HttpServlet{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String p2_Order=request.getParameter("order_id");
		 System.out.println("支付成功订单号为:"+p2_Order);
		/*response.sendRedirect("");*/
		response.sendRedirect("/exp/static/front/frontmain.jsp");
	}
	
	

}
