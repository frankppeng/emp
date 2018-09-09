package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.modle.Cour;
import com.exp.modle.Message;
import com.exp.service.ClientService;
import com.exp.service.CourService;
import com.google.gson.Gson;

@WebServlet("/back/cour/add.jhtml")
public class BackCourAddServlet extends HttpServlet {
	
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
 		 String name = request.getParameter("cour_name");
         String pass = request.getParameter("cour_pass");
         String tel = request.getParameter("cour_tel");
         String email = request.getParameter("cour_email");
         String idcard = request.getParameter("cour_idcard");
         String addressid = request.getParameter("cour_addressid");
         Cour cour=new Cour("0", name, pass, tel, email, idcard, addressid);
         System.out.println(cour.toString());

         Message msg=null;
         Gson gson=new Gson();
         String json=null;
         
     	 CourService es = new CourService();
     	 int result;
     	 
     	 try {
			result = es.Add(cour);
			if (result == 1) {
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
