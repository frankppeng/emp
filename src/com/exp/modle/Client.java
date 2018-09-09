package com.exp.modle;

public class Client {
	private String name;
	private String account;
	private String pass;
	private String tel;
	private String idcard;
	private String sex;
	private String addressid;
	private String email;
	public Client(String name, String account, String pass, String tel,
			String idcard, String sex, String addressid, String email) {
		super();
		this.name = name;
		this.account = account;
		this.pass = pass;
		this.tel = tel;
		this.idcard = idcard;
		this.sex = sex;
		this.addressid = addressid;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [name=" + name + ", account=" + account + ", pass="
				+ pass + ", tel=" + tel + ", idcard=" + idcard + ", sex=" + sex
				+ ", addressid=" + addressid + ", email=" + email + "]";
	}
}