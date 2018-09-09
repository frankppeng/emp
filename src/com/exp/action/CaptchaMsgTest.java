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

/**
 * 测试验证码类短信
 *
 * @author GaoHuanjie
 */
@WebServlet("/duanxin")
public class CaptchaMsgTest extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message msg=null;
        Gson gson=new Gson();
        String json=null;
		 
		 String mobile=request.getParameter("tel");
		 System.out.println(mobile);
		 if(SMSUtils.isMobile(mobile)){
				try {
					System.out.println("发送短信");
					SMSUtils.sendCode(mobile,"3083142");//发送验证码
					msg=new Message("200","发送短信成功","");
				} catch (IOException e) {
					msg=new Message("250","系统异常请稍后重试","");
				}
			}
		 
			System.out.print("您的手机号为："+mobile);
			 json =gson.toJson(msg);
	          response.getWriter().print(json);
	         response.getWriter().close();
	}
	
}