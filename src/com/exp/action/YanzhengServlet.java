package com.exp.action;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Message;
import com.ghj.tool.SMSUtils;
import com.google.gson.Gson;

@WebServlet("/yanzheng")
public class YanzhengServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	Message msg=null;
    Gson gson=new Gson();
    String json=null;
	String mobile=request.getParameter("tel");
	String code=request.getParameter("code");
	try {
		if(SMSUtils.verifyCode(mobile,code)){//校验验证码
			msg=new Message("200","短信验证成功","");
			System.out.println("验证码正确...");
		}else{
			System.out.println("验证码错误...");
			msg=new Message("300","验证码输入错误","");
		}
	} catch (IOException e) {
		msg=new Message("250","系统异常请稍后重试","");
	}
	json =gson.toJson(msg);
    response.getWriter().print(json);
   response.getWriter().close();
}
}
