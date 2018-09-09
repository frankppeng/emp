package com.exp.modle;

public class Login {
	private String account;
	private String session;
	private String status;	
	private String details;
	public Login(){}
	public Login(String account, String session, String status, String details) {
		super();
		this.account = account;
		this.session = session;
		this.status = status;
		this.details = details;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Login [account=" + account + ", session=" + session
				+ ", status=" + status + ", details=" + details + "]";
	}	
}
