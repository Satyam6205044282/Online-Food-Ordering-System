package com.satyamcompany.app.model;

public class MenuType {
	private int menuTypeId;
    private String typeName;
    private String description;
	public MenuType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuType(int menuTypeId, String typeName, String description) {
		super();
		this.menuTypeId = menuTypeId;
		this.typeName = typeName;
		this.description = description;
	}
	public int getmenuTypeId() {
		return menuTypeId;
	}
	public void setmenuTypeId(int menuTypeId) {
		this.menuTypeId = menuTypeId;
	}
	public String gettypeName() {
		return typeName;
	}
	public void settypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MenuType [menuTypeId=" + menuTypeId + ", typeName=" + typeName + ", description=" + description
				+ "]";
	}
    
				
	
}
