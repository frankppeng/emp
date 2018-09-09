package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Message;
import com.exp.service.ClientService;
import com.exp.service.CourService;
import com.google.gson.Gson;

@WebServlet("/back/cour/romove.jhtml")
public class BackCourRomoveServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		System.out.println(account);

		String result;
		Gson gson = new Gson();
		Message msg = null;
		try {
			CourService del = new CourService();
			del.Remove(account);
			msg = new Message("200", "成功", "");
		} catch (Exception e) {
			msg = new Message("250", "失败", "");
		}
		result = gson.toJson(msg);
		response.setContentType("text/json");
		
		response.getWriter().print(result);
		response.getWriter().close();
	}

}
