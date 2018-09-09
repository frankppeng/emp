package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.PageModel;
import com.exp.service.ClientService;
import com.exp.util.BeanJsonUtil;
import com.exp.util.EasyPage;

@WebServlet("/backclientmark")
public class BackClientMarkServlet extends HttpServlet  {

	@Override
	protected void service(HttpServletRequest request,  HttpServletResponse response)
			throws ServletException, IOException {
		
		String page =request.getParameter("page");
		String rows=request.getParameter("rows");
		
		ClientService  empServiceImpl=new ClientService();
		//返回的分页模型对象
		PageModel  model = empServiceImpl.queryPageList(page,rows);
		
		//request.setArribute("pageModel",model);  ${pageModel.list}
		EasyPage  easyPage=new  EasyPage(model.getTotal(),model.getList());
		BeanJsonUtil.writeJson(response, easyPage);
	}
}
