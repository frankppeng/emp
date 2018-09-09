package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.exp.modle.Message;
import com.google.gson.Gson;
@WebServlet("/emailsend")
public class EmailsendServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	 Message msg=null;
     Gson gson=new Gson();
     String json=null;
	System.out.println("asd");
	String emailstr=request.getParameter("email");
	System.out.println(emailstr);
	HtmlEmail email = new HtmlEmail();
    // 这里是SMTP发送服务器的名字：，163的如下：
    email.setHostName("smtp.163.com");
    // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
    email.setAuthentication("helennaygnail@163.com", "YanLove3344");
    // 字符编码集的设置
    email.setCharset("gbk");
    // 收件人的邮箱
    try {
		email.addTo(emailstr);
		// 发送人的邮箱
		email.setFrom("helennaygnail@163.com", "北京市优速物流服务公司");
		// 邮件标题
		email.setSubject("优速快递");
		// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
		email.setMsg("尊敬的会员您好:您的验证码为:3537");
		// 发送
		email.send();
		System.out.println(emailstr);
		if (emailstr!=null) {
			msg = new Message("200", "邮件发送成功","");
		} else {
			msg = new Message("250", "邮件发送失败","");
			
			
		}
		
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		msg = new Message("250", "邮件发送失败","");
	}
    json =gson.toJson(msg);
    
    response.getWriter().print(json);
    response.getWriter().close();
}
}
