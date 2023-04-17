package com.satyamcompany.app.model;

public class Cart {
	private int cartId;
    private int customerId;
    private int menuId;
    private float price;
    private int quantity;
    private float totalAmount;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, int customerId, int menuId, float price, int quantity, float totalAmount) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.menuId = menuId;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getmenuId() {
		return menuId;
	}
	public void setmenuId(int menuId) {
		this.menuId = menuId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Cart-Details [cartId=" + cartId + ", customerId=" + customerId + ", menuId=" + menuId
				+ ", price=" + price + ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}
    
}
