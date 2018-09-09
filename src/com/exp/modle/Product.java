package com.exp.modle;

public class Product {
	private String proNum;
	private String proName;
	private String details;
	public Product(String proNum, String proName, String details) {
		super();
		this.proNum = proNum;
		this.proName = proName;
		this.details = details;
	}
	/**
	 * @return the proNum
	 */
	public String getProNum() {
		return proNum;
	}
	/**
	 * @param proNum the proNum to set
	 */
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	/**
	 * @return the proName
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName the proName to set
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [proNum=" + proNum + ", proName=" + proName
				+ ", details=" + details + "]";
	}
}
