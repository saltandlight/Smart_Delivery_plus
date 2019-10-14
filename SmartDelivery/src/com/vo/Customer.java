package com.vo;

public class Customer {
  String id;
  String pwd;
  String name;
  String addr;
  String phone;
  String gender;
  Integer age;
  
  
public Customer(String id, String pwd) {
	this.id = id;
	this.pwd = pwd;
}
public Customer(String id, String pwd, String name, String phone, String addr,  String gender, Integer age) {
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.addr = addr;
	this.phone = phone;
	this.gender = gender;
	this.age = age;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
  
  
}
