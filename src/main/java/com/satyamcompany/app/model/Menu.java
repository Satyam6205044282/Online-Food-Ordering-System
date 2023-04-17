package com.satyamcompany.app.model;

public class Menu {
	    private int menuId;
	    private String menuName;
	    private float price;
	    private int menuTypeId;
		
	    public Menu() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Menu(int menuId, String menuName, float price, int menuTypeId) {
			super();
			this.menuId = menuId;
			this.menuName = menuName;
			this.price = price;
			this.menuTypeId = menuTypeId;
			
		}

		public int getMenuId() {
			return menuId;
		}

		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getMenuTypeId() {
			return menuTypeId;
		}

		public void setMenuTypeId(int menuTypeId) {
			this.menuTypeId = menuTypeId;
		}

		

		@Override
		public String toString() {
			return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", price=" + price + ", menuTypeId="
					+ menuTypeId + "]";
		}

	    
	    
}