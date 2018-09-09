package com.exp.modle;

public class Message {
	private String code;//错误代码
	private String mess;//错误信息
	private String details;//错误详情
	public Message(String code, String mess, String details) {
		super();
		this.code = code;
		this.mess = mess;
		this.details = details;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", mess=" + mess + ", details="
				+ details + "]";
	}
}
