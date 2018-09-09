package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Message;
import com.google.gson.Gson;
@WebServlet("/validemail")
public class ValidEmailServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	Message msg=null;
    Gson gson=new Gson();
    String json=null;
    String ecode=request.getParameter("ecode");
    System.out.println(ecode);
    if(ecode.equals("3537")){
    	msg=new Message("200","验证成功","");
    }else{
    	msg=new Message("250","验证失败","");
    }
json =gson.toJson(msg);
    
    response.getWriter().print(json);
    response.getWriter().close();
}
}
