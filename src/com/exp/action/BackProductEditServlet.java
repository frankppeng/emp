package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import com.exp.modle.Client;
import com.exp.modle.Message;
import com.exp.modle.Product;
import com.exp.service.ClientService;
import com.exp.service.ProductService;
import com.google.gson.Gson;

@WebServlet("/back/product/edit.jhtml")
public class BackProductEditServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111");
		
		String proNum = request.getParameter("proNum");
        String proName = request.getParameter("proName");
        String pN = request.getParameter("pN");
        
        Message msg=null;
        Product pro = new Product(proNum, proName, pN);
        ProductService ps = new ProductService();
        
        System.out.println(pro.toString());      
        Gson gson=new Gson();
        String json=null;
        int result;
        try {
			
			int row = ps.Edit(pro);
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
