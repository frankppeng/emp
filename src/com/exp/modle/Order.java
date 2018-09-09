package com.exp.modle;

public class Order {
	private String id;
	private String sendname;
	private String sendtel;
	private String senddate;
	private String getname;
	private String gettel;
	private String getdate;
	private String expprice;
	private String sendaddid;
	private String getaddid;
	public Order(String id, String sendname, String sendtel, String senddate,
			String getname, String gettel, String getdate, String expprice,
			String sendaddid, String getaddid) {
		super();
		this.id = id;
		this.sendname = sendname;
		this.sendtel = sendtel;
		this.senddate = senddate;
		this.getname = getname;
		this.gettel = gettel;
		this.getdate = getdate;
		this.expprice = expprice;
		this.sendaddid = sendaddid;
		this.getaddid = getaddid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public String getSendtel() {
		return sendtel;
	}
	public void setSendtel(String sendtel) {
		this.sendtel = sendtel;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getGetname() {
		return getname;
	}
	public void setGetname(String getname) {
		this.getname = getname;
	}
	public String getGettel() {
		return gettel;
	}
	public void setGettel(String gettel) {
		this.gettel = gettel;
	}
	public String getGetdate() {
		return getdate;
	}
	public void setGetdate(String getdate) {
		this.getdate = getdate;
	}
	public String getExpprice() {
		return expprice;
	}
	public void setExpprice(String expprice) {
		this.expprice = expprice;
	}
	public String getSendaddid() {
		return sendaddid;
	}
	public void setSendaddid(String sendaddid) {
		this.sendaddid = sendaddid;
	}
	public String getGetaddid() {
		return getaddid;
	}
	public void setGetaddid(String getaddid) {
		this.getaddid = getaddid;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", sendname=" + sendname + ", sendtel="
				+ sendtel + ", senddate=" + senddate + ", getname=" + getname
				+ ", gettel=" + gettel + ", getdate=" + getdate + ", expprice="
				+ expprice + ", sendaddid=" + sendaddid + ", getaddid="
				+ getaddid + "]";
	}
}