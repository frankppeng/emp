package com.exp.modle;

public class Logistics {
	private String LogId;
	private String OrderId;
	private String CourId;
	private String LogAddress;
	private String LogDate;
	private String LogStatus;
	public Logistics(String logId, String orderId, String courId,
			String logAddress, String logDate, String logStatus) {
		super();
		LogId = logId;
		OrderId = orderId;
		CourId = courId;
		LogAddress = logAddress;
		LogDate = logDate;
		LogStatus = logStatus;
	}
	public String getLogId() {
		return LogId;
	}
	public void setLogId(String logId) {
		LogId = logId;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getCourId() {
		return CourId;
	}
	public void setCourId(String courId) {
		CourId = courId;
	}
	public String getLogAddress() {
		return LogAddress;
	}
	public void setLogAddress(String logAddress) {
		LogAddress = logAddress;
	}
	public String getLogDate() {
		return LogDate;
	}
	public void setLogDate(String logDate) {
		LogDate = logDate;
	}
	public String getLogStatus() {
		return LogStatus;
	}
	public void setLogStatus(String logStatus) {
		LogStatus = logStatus;
	}
	@Override
	public String toString() {
		return "Logistics [LogId=" + LogId + ", OrderId=" + OrderId
				+ ", CourId=" + CourId + ", LogAddress=" + LogAddress
				+ ", LogDate=" + LogDate + ", LogStatus=" + LogStatus + "]";
	}
}