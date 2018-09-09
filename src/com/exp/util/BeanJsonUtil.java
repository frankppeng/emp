package com.exp.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BeanJsonUtil {

	public  static void    writeJson(HttpServletResponse response,Object  object){
		//把数据转换成json
		response.setCharacterEncoding("utf-8");
		Gson  gson=new Gson();
		String    json =  gson.toJson(object);
		//把json发送到前端
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
			pw.print(json);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}  
	
}
