package com.simpana.eventBookingSystem.customerRoomAndHall.bean;

import java.time.LocalDateTime;

public class CustomerRoomAndHallBean {

	private int idCustomerRoomAndHall;
	
	private int idCustomer;
	
	private String type;
	
	private String roomType;
	
	private int quantity;
	
	private LocalDateTime Mdate;

	public CustomerRoomAndHallBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCustomerRoomAndHall() {
		return idCustomerRoomAndHall;
	}

	public void setIdCustomerRoomAndHall(int idCustomerRoomAndHall) {
		this.idCustomerRoomAndHall = idCustomerRoomAndHall;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getMdate() {
		return Mdate;
	}

	public void setMdate(LocalDateTime mdate) {
		Mdate = mdate;
	}
	
	
	
}
