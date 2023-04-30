package com.simpana.eventBookingSystem.customer.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpana.eventBookingSystem.customer.bean.CustomerBean;
import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;
import com.simpana.eventBookingSystem.customer.repository.CustomerRepository;
import com.simpana.eventBookingSystem.customer.service.CustomerService;
import com.simpana.eventBookingSystem.event.bean.EventBean;
import com.simpana.eventBookingSystem.parameter.service.ParameterService;
import com.simpana.eventBookingSystem.util.ParameterConstant;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ParameterService parameterService;

	LocalDateTime dateTime = LocalDateTime.now();

	@Override
	public List<CustomerEntity> getListOfCustomer() {
		List<CustomerBean> listOfCustomerBean = null;
		List<CustomerEntity> listOfCustomerEntity = (List<CustomerEntity>) customerRepository.findAll();
//		listOfCustomerBean = new ArrayList<>();
		List<EventBean> listOfEventBean = new ArrayList<EventBean>();
		int count = 1;
		if (listOfCustomerEntity != null && !"".equals(listOfCustomerEntity)) {
			for (CustomerEntity customerEntity : listOfCustomerEntity) {
				customerEntity.setIdCustomer(count);
				EventBean eventBean = new EventBean(customerEntity);
				listOfEventBean.add(eventBean);
				count++;
			}
		}
		return listOfCustomerEntity;
	}

	@Override
	public List<EventBean> getListOfCustomersEvents() {
		List<CustomerBean> listOfCustomerBean = null;
		List<CustomerEntity> listOfCustomerEntity = (List<CustomerEntity>) customerRepository.findAll();
//		listOfCustomerBean = new ArrayList<>();
		List<EventBean> listOfEventBean = new ArrayList<EventBean>();
		int count = 1;
		if (listOfCustomerEntity != null && !"".equals(listOfCustomerEntity)) {
			for (CustomerEntity customerEntity : listOfCustomerEntity) {
				customerEntity.setIdCustomer(count);
				EventBean eventBean = new EventBean(customerEntity);
				listOfEventBean.add(eventBean);
				count++;
			}
		}
		return listOfEventBean;
	}

	@Override
	public CustomerBean getCustomerById(Integer idCustomer) {
		CustomerBean customerBean = null;
		Optional<CustomerEntity> customerEntity = customerRepository.findById(idCustomer);
		customerBean = new CustomerBean();
		if (customerEntity.isPresent()) {
			BeanUtils.copyProperties(customerEntity.get(), customerBean);
		}
		return customerBean;
	}

	@Override
	public void createCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		if (customerBean != null) {
			CustomerEntity customerEntity = new CustomerEntity();
			LocalDateTime dateTime = LocalDateTime.now();
			customerBean.setMdate(dateTime);
			BeanUtils.copyProperties(customerBean, customerEntity);
			customerEntity = calculateRoomCharges(customerEntity);
			customerRepository.save(customerEntity);
//			CustomerEntity customerEntity2 =  customerRepository.save(customerEntity);
//			for(CustomerRoomAndHallEntity customerRoomAndHallEntity :customerBean.getCustomerRoomAndHall()) {
//				customerRoomAndHallEntity.setIdCustomer(customerEntity2.getIdCustomer());
//				customerRoomAndHallService.createCustomerRoomAndHall(customerRoomAndHallEntity);
//			}
		}
	}
	
	private CustomerEntity calculateRoomCharges(CustomerEntity customerEntity) {
		
		float totalPrice = 0;

		if (customerEntity.getRoomType().equals("AC")) {
			
			totalPrice = totalPrice + (customerEntity.getRoom()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_AC_Room)));			

		} else if (customerEntity.getRoomType().equals( "Non-AC")) {
			
			totalPrice = totalPrice + (customerEntity.getRoom()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_Non_AC_Room)));	

		} else if (customerEntity.getRoom1Type().equals("AC")) {
			
			totalPrice = totalPrice + (customerEntity.getRoom1()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_AC_Room)));	

		} else if (customerEntity.getRoom1Type().equals("Non-AC")) {
			
			
			totalPrice = totalPrice + (customerEntity.getRoom1()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_Non_AC_Room)));

		} else if (customerEntity.getHallType().equals("AC")) {

			totalPrice = totalPrice + (customerEntity.getHall()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_AC_Hall)));	
			
		} else if (customerEntity.getHallType().equals("Non-AC")) {

			totalPrice = totalPrice + (customerEntity.getHall()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_Non_AC_Hall)));	

		} else if (customerEntity.getHall1Type().equals("AC")) {

			totalPrice = totalPrice + (customerEntity.getHall1()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_AC_Hall)));	

		} else if (customerEntity.getHall1Type().equals("Non-AC")) {

			totalPrice = totalPrice + (customerEntity.getHall1()* Integer.parseInt(parameterService.getValueForParam(ParameterConstant.Price_Of_Non_AC_Hall)));	

		}
		
		customerEntity.setTotalPrice(totalPrice);

		return customerEntity;
	}
	
	public CustomerEntity todayBooking() {
		
		CustomerEntity customerEntity = customerRepository.findByMdate(new Date());
		
		return customerEntity;
		
	}
	
	public CustomerEntity weeklyBooking() {
		
		CustomerEntity customerEntity = customerRepository.findByMdate(new Date());
		
		return customerEntity;
		
	}
	

	@Override
	public void updateCustomer(CustomerBean customerBean) {

		if (customerBean != null) {
			CustomerEntity customerEntity = new CustomerEntity();
			LocalDateTime dateTime = LocalDateTime.now();
			customerBean.setMdate(dateTime);
			LocalDate date = LocalDate.now();
			customerBean.setReservationdate(date);
			BeanUtils.copyProperties(customerBean, customerEntity);
			customerRepository.save(customerEntity);
		}
	}

	@Override
	public void deleteCustomer(Integer idCustomer) {

		if (idCustomer != null) {
			customerRepository.deleteById(idCustomer);
		}
	}

}
