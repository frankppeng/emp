package com.exp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.exp.modle.XY;
import com.exp.service.XJsonService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class XJsonServlet
 */
@WebServlet("/XJsonServlet")
public class XJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XJsonService querykindserlvet=new XJsonService();
	     ArrayList<XY> array = querykindserlvet.xjsonS();
	     response.setContentType("text/html; charset=utf-8");
	     JSONArray json=JSONArray.fromObject(array);
	     //返回给前段页面
	     
	     System.out.println(json);
	     PrintWriter out = response.getWriter();  
	     out.println(json);  
	     out.flush();  
	     out.close();   
	}

}
