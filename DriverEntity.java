package com.example.uber;

public class DriverEntity {
	String username;
	String mobile_number;
	String email;
	String password;
	String driving_license;
	String national_id;
	String fav_area;
	public Boolean pending;
	double balance=0;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriving_license() {
		return driving_license;
	}
	public void setDriving_license(String driving_license) {
		this.driving_license = driving_license;
	}
	public String getNational_id() {
		return national_id;
	}
	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}
	public String getFav_area() {
		return fav_area;
	}
	public void setFav_area(String fav_area) {
		this.fav_area = fav_area;
	}
	public Boolean getPending() {
		return pending;
	}
	public void setPending(Boolean pending) {
		this.pending = pending;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
