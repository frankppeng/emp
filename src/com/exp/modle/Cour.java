package com.exp.modle;

public class Cour {
	private String account;
	private String name;
	private String pass;
	private String tel;
	private String email;
	private String idcard;
	private String addressid;
	public Cour(String account, String name, String pass, String tel,
			String email, String idcard, String addressid) {
		super();
		this.account = account;
		this.name = name;
		this.pass = pass;
		this.tel = tel;
		this.email = email;
		this.idcard = idcard;
		this.addressid = addressid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	@Override
	public String toString() {
		return "Cour [account=" + account + ", name=" + name + ", pass=" + pass
				+ ", tel=" + tel + ", email=" + email + ", idcard=" + idcard
				+ ", addressid=" + addressid + "]";
	}
}
