package com.satyamcompany.app.model;

public class Rating {
	private int orderId;
    private int menuId;
    private int rate;
    private String feedback;
    private String dateRecorded;
    private int customerId;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int orderId, int menuId, int rate, String feedback, String dateRecorded, int customerId) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.rate = rate;
		this.feedback = feedback;
		this.dateRecorded = dateRecorded;
		this.customerId = customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getDateRecorded() {
		return dateRecorded;
	}
	public void setDateRecorded(String dateRecorded) {
		this.dateRecorded = dateRecorded;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Rating [orderId=" + orderId + ", menuId=" + menuId + ", rate=" + rate + ", feedback=" + feedback
				+ ", dateRecorded=" + dateRecorded + ", customerId=" + customerId + "]";
	}
    
}
