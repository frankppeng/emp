package com.exp.modle;

public class User {
	private String name;
	private String account;
	private String pass;
	private String tel;
	private String email;
	private String sex;
	private String idcard;
	public User(String name, String account, String pass, String tel,
			String email, String sex, String idcard) {
		super();
		this.name = name;
		this.account = account;
		this.pass = pass;
		this.tel = tel;
		this.email = email;
		this.sex = sex;
		this.idcard = idcard;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", account=" + account + ", pass=" + pass
				+ ", tel=" + tel + ", email=" + email + ", sex=" + sex
				+ ", idcard=" + idcard + "]";
	}
}
