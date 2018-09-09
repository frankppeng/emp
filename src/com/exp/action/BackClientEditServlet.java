package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.exp.modle.Client;
import com.exp.modle.Message;
import com.exp.service.ClientService;
import com.google.gson.Gson;

@WebServlet("/back/client/edit.jhtml")
public class BackClientEditServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("client_name");
        String account = request.getParameter("account");
        String pass = request.getParameter("client_pass");
        String tel = request.getParameter("client_tel");
        String idcard = request.getParameter("client_idcard");
        String sex = request.getParameter("client_sex");
        String addressid = request.getParameter("client_addressid");
        String email = request.getParameter("client_email");
        
        Message msg=null;
        Client client = new Client(name,account,pass,tel,idcard,sex,addressid,email);
        ClientService es = new ClientService();
        
        System.out.println(client.toString());      
        Gson gson=new Gson();
        String json=null;
        int result;
        try {
			
			int row = es.Edit(client);
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
