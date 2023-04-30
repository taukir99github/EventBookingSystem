package com.simpana.eventBookingSystem.customer.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;

public class CustomerBean {

	private Integer idCustomer;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private LocalDateTime mdate;
	
	private LocalDate Reservationdate;
	
	private String gender;
	
	private long phoneNo;
	
	private long addharNo;
	
	private String email;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private Date startDate;
	
	private Date endDate;
	
	private int totalGuest;
	
	private boolean veg;
	
	private boolean nonVeg;
	
	private String roomType;
	
	private String room1Type;
	
	private String hallType;
	
	private String hall1Type;
	
	private int room;
	
	private int room1;
	
	private int hall;
	
	private int hall1;

	private String eventType;
	
	private float TotalPrice;

//	private List<CustomerRoomAndHallEntity> customerRoomAndHall;
	
	public CustomerBean() {
		super();
	}

	

	
	public float getTotalPrice() {
		return TotalPrice;
	}




	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}




	public String getEventType() {
		return eventType;
	}



	public void setEventType(String eventType) {
		this.eventType = eventType;
	}



	public Integer getIdCustomer() {
		return idCustomer;
	}



	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getAge() {
		return age;
	}
	



	public LocalDate getReservationdate() {
		return Reservationdate;
	}



	public void setReservationdate(LocalDate reservationdate) {
		Reservationdate = reservationdate;
	}



	public void setAge(int age) {
		this.age = age;
	}



	


	public LocalDateTime getMdate() {
		return mdate;
	}




	public void setMdate(LocalDateTime mdate) {
		this.mdate = mdate;
	}




	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public long getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}



	public long getAddharNo() {
		return addharNo;
	}



	public void setAddharNo(long addharNo) {
		this.addharNo = addharNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public int getTotalGuest() {
		return totalGuest;
	}
	





	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public void setTotalGuest(int totalGuest) {
		this.totalGuest = totalGuest;
	}



	public boolean isVeg() {
		return veg;
	}



	public void setVeg(boolean veg) {
		this.veg = veg;
	}



	public boolean isNonVeg() {
		return nonVeg;
	}



	public void setNonVeg(boolean nonVeg) {
		this.nonVeg = nonVeg;
	}



//	public List<CustomerRoomAndHallEntity> getCustomerRoomAndHall() {
//		return customerRoomAndHall;
//	}
//
//
//
//	public void setCustomerRoomAndHall(List<CustomerRoomAndHallEntity> customerRoomAndHall) {
//		this.customerRoomAndHall = customerRoomAndHall;
//	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public String getRoom1Type() {
		return room1Type;
	}



	public void setRoom1Type(String room1Type) {
		this.room1Type = room1Type;
	}



	public String getHallType() {
		return hallType;
	}



	public void setHallType(String hallType) {
		this.hallType = hallType;
	}



	public String getHall1Type() {
		return hall1Type;
	}



	public void setHall1Type(String hall1Type) {
		this.hall1Type = hall1Type;
	}



	public int getRoom() {
		return room;
	}



	public void setRoom(int room) {
		this.room = room;
	}



	public int getRoom1() {
		return room1;
	}



	public void setRoom1(int room1) {
		this.room1 = room1;
	}



	public int getHall() {
		return hall;
	}



	public void setHall(int hall) {
		this.hall = hall;
	}



	public int getHall1() {
		return hall1;
	}



	public void setHall1(int hall1) {
		this.hall1 = hall1;
	}

	
	
	
}