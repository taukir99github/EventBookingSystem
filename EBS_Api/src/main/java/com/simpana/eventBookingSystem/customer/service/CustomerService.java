package com.simpana.eventBookingSystem.customer.service;

import java.util.List;

import com.simpana.eventBookingSystem.customer.bean.CustomerBean;
import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;
import com.simpana.eventBookingSystem.event.bean.EventBean;

public interface CustomerService {

	public List<CustomerEntity> getListOfCustomer();
	
	public List<EventBean> getListOfCustomersEvents();

	public void createCustomer(CustomerBean customerBean);

	public void updateCustomer(CustomerBean customerBean);

	public void deleteCustomer(Integer idCustomer);

	CustomerBean getCustomerById(Integer idCustomer);

}
