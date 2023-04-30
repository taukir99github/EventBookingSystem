package com.simpana.eventBookingSystem.customerRoomAndHall.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EBS_CUSTOMER_ROOM_AND_HALL")
public class CustomerRoomAndHallEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_CUSTOMER_ROOM_AND_HALL")
	private int idCustomerRoomAndHall;

	@Column(name = "ID_CUSTOMER")
	private int idCustomer;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "ROOM_TYPE")
	private String roomType;

	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "M_DATE")
	private LocalDateTime Mdate;

	public CustomerRoomAndHallEntity() {
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
