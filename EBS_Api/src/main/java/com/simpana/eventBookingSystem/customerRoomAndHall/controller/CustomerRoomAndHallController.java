package com.simpana.eventBookingSystem.customerRoomAndHall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpana.eventBookingSystem.customerRoomAndHall.bean.CustomerRoomAndHallBean;
import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;
import com.simpana.eventBookingSystem.customerRoomAndHall.service.CustomerRoomAndHallService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/customerRoomAndHallController")
public class CustomerRoomAndHallController {

	@Autowired
	CustomerRoomAndHallService customerRoomAndHallService;

	@RequestMapping(value = "/getListOfCustomerRoomAndHall", method = RequestMethod.POST)
	public List<CustomerRoomAndHallBean> getListOfCustomerRoomAndHall(HttpServletRequest req, HttpServletResponse res,
			@RequestBody CustomerRoomAndHallBean customerRoomAndHallBean, @RequestParam(required = false) Integer limit) {

		return customerRoomAndHallService.getListOfCustomerRoomAndHall(customerRoomAndHallBean, limit);
	}

	@RequestMapping(value = "getCustomerRoomAndHallById/{idCustomerRoomAndHall}", method = RequestMethod.POST)
	public CustomerRoomAndHallBean getCustomerRoomAndHallById(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idCustomerRoomAndHall") Integer idCustomerRoomAndHall) {

		CustomerRoomAndHallBean customerRoomAndHallBean = null;
		if (idCustomerRoomAndHall != 0) {
			customerRoomAndHallBean = customerRoomAndHallService.getCustomerRoomAndHallById(idCustomerRoomAndHall);
			if (customerRoomAndHallBean != null && !"".equals(customerRoomAndHallBean)) {
				return customerRoomAndHallBean;
			}
		}
		return customerRoomAndHallBean;
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public void createCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestBody CustomerRoomAndHallEntity customerRoomAndHallEntity) {
		customerRoomAndHallService.createCustomerRoomAndHall(customerRoomAndHallEntity);
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public void updateCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestBody CustomerRoomAndHallBean customerRoomAndHallBean) {
		customerRoomAndHallService.updateCustomerRoomAndHall(customerRoomAndHallBean);
	}

	@RequestMapping(value = "/deleteCustomer{idCustomer}", method = RequestMethod.DELETE)
	public void deleteCustomer(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idCustomer") Integer idCustomer) {
		customerRoomAndHallService.deleteCustomerRoomAndHall(idCustomer);
	}

}
