package com.vo;

public class Delivery {
	String delivery_id;
	String order_id;
	String car_id;
	String start_x;
	String start_y;
	String end_x;
	String end_y;
	int fee;
	String distance;
	String time;
	String departure_time;
	String arrive_time;
	int delivery_status;
	
	public Delivery(String delivery_id, String order_id, String car_id, String start_x, String start_y, String end_x,
			String end_y, int fee, String distance, String time, String departure_time, String arrive_time,
			int delivery_status) {
		this.delivery_id = delivery_id;
		this.order_id = order_id;
		this.car_id = car_id;
		this.start_x = start_x;
		this.start_y = start_y;
		this.end_x = end_x;
		this.end_y = end_y;
		this.fee = fee;
		this.distance = distance;
		this.time = time;
		this.departure_time = departure_time;
		this.arrive_time = arrive_time;
		this.delivery_status = delivery_status;
	}

	public String getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getStart_x() {
		return start_x;
	}

	public void setStart_x(String start_x) {
		this.start_x = start_x;
	}

	public String getStart_y() {
		return start_y;
	}

	public void setStart_y(String start_y) {
		this.start_y = start_y;
	}

	public String getEnd_x() {
		return end_x;
	}

	public void setEnd_x(String end_x) {
		this.end_x = end_x;
	}

	public String getEnd_y() {
		return end_y;
	}

	public void setEnd_y(String end_y) {
		this.end_y = end_y;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public int getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(int delivery_status) {
		this.delivery_status = delivery_status;
	}

	@Override
	public String toString() {
		return "Delivery [delivery_id=" + delivery_id + ", order_id=" + order_id + ", car_id=" + car_id + ", start_x="
				+ start_x + ", start_y=" + start_y + ", end_x=" + end_x + ", end_y=" + end_y + ", fee=" + fee
				+ ", distance=" + distance + ", time=" + time + ", departure_time=" + departure_time + ", arrive_time="
				+ arrive_time + ", delivery_status=" + delivery_status + "]";
	}
	
	
}
