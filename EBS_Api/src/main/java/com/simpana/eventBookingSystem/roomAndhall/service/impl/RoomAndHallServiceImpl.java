//package com.simpana.eventBookingSystem.roomAndhall.service.impl;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.simpana.eventBookingSystem.customer.bean.CustomerBean;
//import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;
//import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;
//import com.simpana.eventBookingSystem.roomAndhall.bean.RoomAndHallBean;
//import com.simpana.eventBookingSystem.roomAndhall.repository.RoomAndHallRepository;
//import com.simpana.eventBookingSystem.roomAndhall.service.RoomAndHallService;
//
//@Service
//public class RoomAndHallServiceImpl implements RoomAndHallService {
//
//	@Autowired
//	RoomAndHallRepository roomAndHallRepository;
//
//	LocalDateTime dateTime = LocalDateTime.now();
//
//	@Override
//	public List<RoomAndHallBean> getListOfCustomer(CustomerBean customerBean, Integer limit) {
//		List<CustomerBean> listOfCustomerBean = null;
//		List<CustomerEntity> listOfCustomerEntity = (List<CustomerEntity>) customerRepository.findAll();
//		listOfCustomerBean = new ArrayList<>();
//		if (listOfCustomerEntity != null && !"".equals(listOfCustomerEntity)) {
//			CustomerBean customerBean2 = null;
//			for (CustomerEntity customerEntity : listOfCustomerEntity) {
//				customerBean2 = new CustomerBean();
//				BeanUtils.copyProperties(customerEntity, customerBean2);
//				listOfCustomerBean.add(customerBean2);
//			}
//		}
//		return listOfCustomerBean;
//	}
//
//	@Override
//	public CustomerBean getCustomerById(Integer idCustomer) {
//		CustomerBean customerBean = null;
//		Optional<CustomerEntity> customerEntity = customerRepository.findById(idCustomer);
//		customerBean = new CustomerBean();
//		if (customerEntity.isPresent()) {
//			BeanUtils.copyProperties(customerEntity.get(), customerBean);
//		}
//		return customerBean;
//	}
//
//	@Override
//	public void createCustomer(CustomerBean customerBean) {
//		// TODO Auto-generated method stub
//		if (customerBean != null) {
//			CustomerEntity customerEntity = new CustomerEntity();
//			LocalDateTime dateTime = LocalDateTime.now();
//			customerBean.setMdate(dateTime);
//			BeanUtils.copyProperties(customerBean, customerEntity);
//			CustomerEntity customerEntity2 = customerRepository.save(customerEntity);
//			for (CustomerRoomAndHallEntity customerRoomAndHallEntity : customerBean.getCustomerRoomAndHall()) {
//				customerRoomAndHallEntity.setIdCustomer(customerEntity2.getIdCustomer());
//				customerRoomAndHallService.createCustomerRoomAndHall(customerRoomAndHallEntity);
//			}
//		}
//	}
//
//	@Override
//	public void updateCustomer(CustomerBean customerBean) {
//
//		if (customerBean != null) {
//			CustomerEntity customerEntity = new CustomerEntity();
//			LocalDateTime dateTime = LocalDateTime.now();
//			customerBean.setMdate(dateTime);
//			BeanUtils.copyProperties(customerBean, customerEntity);
//			customerRepository.save(customerEntity);
//		}
//	}
//
//	@Override
//	public void deleteCustomer(Integer idCustomer) {
//
//		if (idCustomer != null) {
//			customerRepository.deleteById(idCustomer);
//		}
//	}
//}
