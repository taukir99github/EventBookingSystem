package com.simpana.eventBookingSystem.event.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;

public class EventBean {
	private String title;
	private Date start;
	private String end;
    
    
    
    
	public EventBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventBean(CustomerEntity customerEntity) {
		super();
		this.title = customerEntity.getFirstName() + customerEntity.getLastName() ;
//		this.start = dateFormate(customerEntity.getStartDate());
		this.start = customerEntity.getStartDate();
		this.end = dateFormate(customerEntity.getEndDate());
	}
	
	public String dateFormate(Date date){
		if(date != null) {     
		String pattern = "EEE MMM dd yyyy HH:mm:ss "; 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date1 = simpleDateFormat.format(date);
		
		return date1;
		}
		return null;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	
	
	
}
