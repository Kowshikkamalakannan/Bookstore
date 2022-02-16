package com.kowshik.bookstore.dto;

public class UserRegistrationDto {
	private String shopName;
	private String email;
	private String password;
	private String phonenumber;
	
	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String shopName, String email,String phonenumber, String password) {
		super();  
		this.shopName = shopName;
		this.email = email;
		this.phonenumber=phonenumber;
		this.password = password;
		
	}
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
