package com.vo;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	String sub_id="PID";
	Integer sub_id2;
	String product_id;
	String product_name;
	Integer product_price;
	String product_pic1;
	MultipartFile mf;
	
	
	
	public Product() {
		this.product_id = sub_id;

	}
	public Product(String product_id, String product_name, Integer product_price, String product_pic1, 
			MultipartFile mf) {
		this.product_id = sub_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_pic1 = product_pic1;
		this.mf=mf;
//		System.out.println("product_id:"+product_id);
	}

	public Product(String product_name, Integer product_price, MultipartFile mf) {
		this.product_id = sub_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.mf=mf;
//		System.out.println("product_id:"+product_id);
	}
	public Product(String product_name, Integer product_price, String product_pic1, MultipartFile mf) {
		this.product_id = sub_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_pic1=product_pic1;
		this.mf=mf;
//		System.out.println("product_id:"+product_id);
	}
	
	public Product(String product_name, Integer product_price, String product_pic1) {
		this.product_id = sub_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_pic1 = product_pic1;
//		System.out.println("product_id:"+product_id);
	}
	
	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public Integer getProduct_price() {
		return product_price;
	}


	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}


	public String getProduct_pic1() {
		return product_pic1;
	}


	public void setProduct_pic1(String product_pic1) {
		this.product_pic1 = product_pic1;
	}


	public MultipartFile getMf() {
		return mf;
	}

	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}

	public Integer getSub_id2() {
		return sub_id2;
	}
	public void setSub_id2(Integer sub_id2) {
		this.sub_id2 = sub_id2;
	}
	
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_pic1=" + product_pic1 + "]";
	}
	
	

}
