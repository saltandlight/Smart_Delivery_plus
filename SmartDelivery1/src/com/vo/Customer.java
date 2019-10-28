package com.vo;

public class Customer {
  String customer_id;
  String customer_pwd;
  String customer_name;
  String customer_phone;
  String customer_addr;
  String customer_gender;
  Integer customer_age;
  Integer admin_check;

  
  
  
  public Customer() {

  }




  public Customer(String customer_id, String customer_pwd) {
	super();
	this.customer_id = customer_id;
	this.customer_pwd = customer_pwd;
  }




public Customer(String customer_id, String customer_pwd, String customer_name, String customer_phone,
		String customer_addr, String customer_gender, Integer customer_age, Integer admin_check) {
	super();
	this.customer_id = customer_id;
	this.customer_pwd = customer_pwd;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.customer_addr = customer_addr;
	this.customer_gender = customer_gender;
	this.customer_age = customer_age;
	this.admin_check = admin_check;
}




public String getCustomer_id() {
	return customer_id;
}




public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}




public String getCustomer_pwd() {
	return customer_pwd;
}




public void setCustomer_pwd(String customer_pwd) {
	this.customer_pwd = customer_pwd;
}




public String getCustomer_name() {
	return customer_name;
}




public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}




public String getCustomer_phone() {
	return customer_phone;
}




public void setCustomer_phone(String customer_phone) {
	this.customer_phone = customer_phone;
}




public String getCustomer_addr() {
	return customer_addr;
}




public void setCustomer_addr(String customer_addr) {
	this.customer_addr = customer_addr;
}




public String getCustomer_gender() {
	return customer_gender;
}




public void setCustomer_gender(String customer_gender) {
	this.customer_gender = customer_gender;
}




public Integer getCustomer_age() {
	return customer_age;
}




public void setCustomer_age(Integer customer_age) {
	this.customer_age = customer_age;
}




public Integer getAdmin_check() {
	return admin_check;
}




public void setAdmin_check(Integer admin_check) {
	this.admin_check = admin_check;
}




@Override
public String toString() {
	return "Customer [customer_id=" + customer_id + ", customer_pwd=" + customer_pwd + ", customer_name="
			+ customer_name + ", customer_phone=" + customer_phone + ", customer_addr=" + customer_addr
			+ ", customer_gender=" + customer_gender + ", customer_age=" + customer_age + ", admin_check=" + admin_check
			+ "]";
}

  
}
