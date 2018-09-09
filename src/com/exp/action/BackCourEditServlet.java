package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Cour;
import com.exp.modle.Message;
import com.exp.service.CourService;
import com.google.gson.Gson;

@WebServlet("/back/cour/edit.jhtml")
public class BackCourEditServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("edit");
		String account = request.getParameter("account");
		String name = request.getParameter("cour_name");
        String pass = request.getParameter("cour_pass");
        String tel = request.getParameter("cour_tel");
        String email = request.getParameter("cour_email");
        String idcard = request.getParameter("cour_idcard");
        String addressid = request.getParameter("cour_addressid");
        Cour cour = new Cour(account, name, pass, tel, email, idcard, addressid);
        System.out.println(cour.toString());      
        
        Message msg=null;
        CourService es = new CourService();
        
        Gson gson=new Gson();
        String json=null;
        int result;
        try {
			
			int row = es.Edit(cour);
			if (row == 1) {
				msg=new Message("200","成功","");				
			} else {
				msg=new Message("210","失败","");	
			}
		} catch (Exception e) {
            msg=new Message("250","失败","");
		}
   
		json =gson.toJson(msg);
		
		response.getWriter().print(json);
		response.getWriter().close();
	}

}
