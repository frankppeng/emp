package com.exp.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store")
public class StoreOrderServlet extends HttpServlet{
	    ServletConfig  config;
		String ipinfo=null;
		String info=null;
		@Override
		public void init(ServletConfig config) throws ServletException {
				this.config=config;
			
		}
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	try {
		StoreOrderServlet ss=new StoreOrderServlet();
		ss.init();
		request.getServletContext().getServerInfo();
        //发送POST请求

		URL url = new URL("http://192.168.50.165:8080/Flowers/ordservlet");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setUseCaches(false);
        conn.setDoOutput(true);
        
        //获取响应状态
        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            System.out.println("connect failed!");
            return ;
        }
        //获取响应内容体
        String line, json = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        while ((line = in.readLine()) != null) {
        	json += line + "\n";
        }
        System.out.println(json);
        in.close();
        response.setContentType("text/json");
    	response.getWriter().println(json);
    	response.getWriter().close();
    	conn.disconnect();
    } catch (IOException e) {
        e.printStackTrace(System.out);
    }finally{}
}
}
