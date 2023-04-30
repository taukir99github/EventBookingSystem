package com.simpana.eventBookingSystem.customer.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EBS_CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Integer idCustomer;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "M_DATE")
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDateTime mdate;
	
	@Column(name = "RESERVATION_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate Reservationdate;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "PHONE_NO")
	private long phoneNo;
	
	@Column(name = "ADDHAR_NO")
	private long addharNo;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "START_TIME")
	private LocalTime startTime;
	
	@Column(name = "END_TIME")
	private LocalTime endTime;
	
	@Column(name = "START_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Column(name = "END_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Column(name = "TOTAL_GUEST")
	private int totalGuest;
	
	@Column(name = "VEG")
	private boolean veg;
	
	@Column(name = "NON_VEG")
	private boolean nonVeg;
	
	@Column(name = "ROOM_TYPE")
	private String roomType;
	
	@Column(name = "ROOM1_TYPE")
	private String room1Type;
	
	@Column(name = "HALL_TYPE")
	private String hallType;
	
	@Column(name = "HALL1_TYPE")
	private String hall1Type;
	
	@Column(name = "ROOM")
	private int room;
	
	@Column(name = "ROOM1")
	private int room1;
	
	@Column(name = "HALL")
	private int hall;
	
	@Column(name = "HALL1")
	private int hall1;

	@Column(name = "EVENT_TYPE")
	private String eventType;

	@Column(name = "TOTAL_PRICE")
	private float TotalPrice;
	

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public float getTotalPrice() {
		return TotalPrice;
	}



	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}



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



	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotalGuest() {
		return totalGuest;
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

	public LocalDate getReservationdate() {
		return Reservationdate;
	}

	public void setReservationdate(LocalDate reservationdate) {
		Reservationdate = reservationdate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	

	
}
