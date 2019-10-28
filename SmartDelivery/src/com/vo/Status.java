package com.vo;

import java.util.Date;

public class Status {
	
	String car_id;
	String car_num;
	String driver_name;
	String driver_phone;
	String car_x;
	String car_y;
	String car_temper;
	String car_humid;
	String car_pic;
	String car_impact;
	Date current_timel;
	
	public Status() {
		
	}

	public Status(String car_id, String car_num, String driver_name, String driver_phone, String car_x, String car_y,
			String car_temper, String car_humid, String car_pic, String car_impact, Date current_timel) {
	
		this.car_id = car_id;
		this.car_num = car_num;
		this.driver_name = driver_name;
		this.driver_phone = driver_phone;
		this.car_x = car_x;
		this.car_y = car_y;
		this.car_temper = car_temper;
		this.car_humid = car_humid;
		this.car_pic = car_pic;
		this.car_impact = car_impact;
		this.current_timel = current_timel;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getDriver_phone() {
		return driver_phone;
	}

	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}

	public String getCar_x() {
		return car_x;
	}

	public void setCar_x(String car_x) {
		this.car_x = car_x;
	}

	public String getCar_y() {
		return car_y;
	}

	public void setCar_y(String car_y) {
		this.car_y = car_y;
	}

	public String getCar_temper() {
		return car_temper;
	}

	public void setCar_temper(String car_temper) {
		this.car_temper = car_temper;
	}

	public String getCar_humid() {
		return car_humid;
	}

	public void setCar_humid(String car_humid) {
		this.car_humid = car_humid;
	}

	public String getCar_pic() {
		return car_pic;
	}

	public void setCar_pic(String car_pic) {
		this.car_pic = car_pic;
	}

	public String getCar_impact() {
		return car_impact;
	}

	public void setCar_impact(String car_impact) {
		this.car_impact = car_impact;
	}

	public Date getCurrent_timel() {
		return current_timel;
	}

	public void setCurrent_timel(Date current_timel) {
		this.current_timel = current_timel;
	}

	@Override
	public String toString() {
		return "Status [car_id=" + car_id + ", car_num=" + car_num + ", driver_name=" + driver_name + ", driver_phone="
				+ driver_phone + ", car_x=" + car_x + ", car_y=" + car_y + ", car_temper=" + car_temper + ", car_humid="
				+ car_humid + ", car_pic=" + car_pic + ", car_impact=" + car_impact + ", current_timel=" + current_timel
				+ "]";
	}
	
	
	
	
	
	
}
