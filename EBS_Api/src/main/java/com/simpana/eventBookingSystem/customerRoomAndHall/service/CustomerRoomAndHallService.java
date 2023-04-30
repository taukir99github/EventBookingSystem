package com.simpana.eventBookingSystem.customerRoomAndHall.service;

import java.util.List;

import com.simpana.eventBookingSystem.customerRoomAndHall.bean.CustomerRoomAndHallBean;
import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;

public interface CustomerRoomAndHallService {

	public List<CustomerRoomAndHallBean> getListOfCustomerRoomAndHall(CustomerRoomAndHallBean customerRoomAndHallBean, Integer limit);

	public void createCustomerRoomAndHall(CustomerRoomAndHallEntity customerRoomAndHallEntity);

	public void updateCustomerRoomAndHall(CustomerRoomAndHallBean customerRoomAndHallBean);

	public void deleteCustomerRoomAndHall(Integer idCustomerRoomAndHall);

	CustomerRoomAndHallBean getCustomerRoomAndHallById(Integer idCustomerRoomAndHall);
}
