package com.simpana.eventBookingSystem.roomAndhall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EBS_ROOM_AND_HALL")
public class RoomAndHallEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ROOM_AND_HALL_ID")
	private int idRoomAndHall;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "ROOM_OR_HALL_TYPE")
	private String roomOrhallType;
	
	@Column(name = "PRICE")
	private int price;

	public RoomAndHallEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdRoomAndHall() {
		return idRoomAndHall;
	}

	public void setIdRoomAndHall(int idRoomAndHall) {
		this.idRoomAndHall = idRoomAndHall;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoomOrhallType() {
		return roomOrhallType;
	}

	public void setRoomOrhallType(String roomOrhallType) {
		this.roomOrhallType = roomOrhallType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
