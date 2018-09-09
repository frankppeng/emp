package com.exp.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.exp.action.BackUserLoginServlet;

public class OnlineListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Online Listener created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Online Listener destroyed");
		BackUserLoginServlet buls = new BackUserLoginServlet();
		buls.remove();
		System.out.println("移除");
	}
}
