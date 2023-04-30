package com.simpana.eventBookingSystem.customerRoomAndHall.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpana.eventBookingSystem.customerRoomAndHall.bean.CustomerRoomAndHallBean;
import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;
import com.simpana.eventBookingSystem.customerRoomAndHall.repository.CustomerRoomAndHallRepository;
import com.simpana.eventBookingSystem.customerRoomAndHall.service.CustomerRoomAndHallService;

@Service
public class CustomerRoomAndHallServiceImpl implements CustomerRoomAndHallService {
	@Autowired
	CustomerRoomAndHallRepository customerRoomAndHallRepository;

	LocalDateTime dateTime = LocalDateTime.now();
	
	@Override
	public List<CustomerRoomAndHallBean> getListOfCustomerRoomAndHall(CustomerRoomAndHallBean customerRoomAndHallBean, Integer limit) {
		List<CustomerRoomAndHallBean> listOfCustomerRoomAndHallBean = null;
		List<CustomerRoomAndHallEntity> listOfCustomerRoomAndHallEntity = (List<CustomerRoomAndHallEntity>) customerRoomAndHallRepository.findAll();
		listOfCustomerRoomAndHallBean = new ArrayList<>();
		if (listOfCustomerRoomAndHallEntity != null && !"".equals(listOfCustomerRoomAndHallEntity)) {
			CustomerRoomAndHallBean customerRoomAndHallBean2 = null;
			for (CustomerRoomAndHallEntity customerRoomAndHallEntity : listOfCustomerRoomAndHallEntity) {
				customerRoomAndHallBean2 = new CustomerRoomAndHallBean();
				BeanUtils.copyProperties(customerRoomAndHallEntity, customerRoomAndHallBean2);
				listOfCustomerRoomAndHallBean.add(customerRoomAndHallBean2);
			}
		}
		return listOfCustomerRoomAndHallBean;
	}

	@Override
	public CustomerRoomAndHallBean getCustomerRoomAndHallById(Integer idCustomerRoomAndHall) {
		CustomerRoomAndHallBean customerRoomAndHallBean = null;
		Optional<CustomerRoomAndHallEntity> customerRoomAndHallEntity = customerRoomAndHallRepository.findById(idCustomerRoomAndHall);
		customerRoomAndHallBean = new CustomerRoomAndHallBean();
		if (customerRoomAndHallEntity.isPresent()) {
			BeanUtils.copyProperties(customerRoomAndHallEntity.get(), customerRoomAndHallBean);
		}
		return customerRoomAndHallBean;
	}

	@Override
	public void createCustomerRoomAndHall(CustomerRoomAndHallEntity customerRoomAndHallEntity) {
		// TODO Auto-generated method stub
		if (customerRoomAndHallEntity != null) {
			LocalDateTime dateTime = LocalDateTime.now();
			customerRoomAndHallEntity.setMdate(dateTime);
			customerRoomAndHallRepository.save(customerRoomAndHallEntity);
		}
	}

	@Override
	public void updateCustomerRoomAndHall(CustomerRoomAndHallBean customerRoomAndHallBean) {

		if (customerRoomAndHallBean != null) {
			CustomerRoomAndHallEntity customerRoomAndHallEntity = new CustomerRoomAndHallEntity();
			LocalDateTime dateTime = LocalDateTime.now();
			customerRoomAndHallBean.setMdate(dateTime);
			BeanUtils.copyProperties(customerRoomAndHallBean, customerRoomAndHallEntity);
			customerRoomAndHallRepository.save(customerRoomAndHallEntity);
		}
	}

	@Override
	public void deleteCustomerRoomAndHall(Integer idCustomerRoomAndHall) {

		if (idCustomerRoomAndHall != null) {
			customerRoomAndHallRepository.deleteById(idCustomerRoomAndHall);
		}
	}

}
