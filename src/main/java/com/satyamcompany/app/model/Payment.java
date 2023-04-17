package com.satyamcompany.app.model;

public class Payment {
	 private int paymentId;
	    private int orderId;
	    private float finalAmount;
	    private String paidBy;
	    private String paymentDate;
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Payment(int paymentId, int orderId, float finalAmount, String paidBy, String paymentDate) {
			super();
			this.paymentId = paymentId;
			this.orderId = orderId;
			this.finalAmount = finalAmount;
			this.paidBy = paidBy;
			this.paymentDate = paymentDate;
		}
		public int getpaymentId() {
			return paymentId;
		}
		public void setpaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getorderId() {
			return orderId;
		}
		public void setorderId(int orderId) {
			this.orderId = orderId;
		}
		public float getfinalAmount() {
			return finalAmount;
		}
		public void setfinalAmount(float finalAmount) {
			this.finalAmount = finalAmount;
		}
		public String getpaidBy() {
			return paidBy;
		}
		public void setpaidBy(String paidBy) {
			this.paidBy = paidBy;
		}
		public String getpaymentDate() {
			return paymentDate;
		}
		public void setpaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}
		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", finalAmount=" + finalAmount + ", paidBy="
					+ paidBy + ", paymentDate=" + paymentDate + "]";
		}
	  
}
