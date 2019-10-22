package com.vo;

public class Order {
	String order_id;
	String customer_id;
	int order_price;
	String order_date;
	String order_addr;
	String order_phone;
	String order_pay;
	String order_wea;
	String cx;
	String cy;
	String current_time;
	int order_status;
	String product_id;
	
	public Order(String order_id, String customer_id, int order_price, String order_date, String order_addr,
			String order_phone, String order_pay, String order_wea, String cx, String cy, String current_time,
			int order_status, String product_id) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_price = order_price;
		this.order_date = order_date;
		this.order_addr = order_addr;
		this.order_phone = order_phone;
		this.order_pay = order_pay;
		this.order_wea = order_wea;
		this.cx = cx;
		this.cy = cy;
		this.current_time = current_time;
		this.order_status = order_status;
		this.product_id = product_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_pay() {
		return order_pay;
	}
	public void setOrder_pay(String order_pay) {
		this.order_pay = order_pay;
	}
	public String getOrder_wea() {
		return order_wea;
	}
	public void setOrder_wea(String order_wea) {
		this.order_wea = order_wea;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getCy() {
		return cy;
	}
	public void setCy(String cy) {
		this.cy = cy;
	}
	public String getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", order_price=" + order_price
				+ ", order_date=" + order_date + ", order_addr=" + order_addr + ", order_phone=" + order_phone
				+ ", order_pay=" + order_pay + ", order_wea=" + order_wea + ", cx=" + cx + ", cy=" + cy
				+ ", current_time=" + current_time + ", order_status=" + order_status + ", product_id=" + product_id
				+ "]";
	}
	
	
}
