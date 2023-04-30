package com.simpana.eventBookingSystem.customer.controller;

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

import com.simpana.eventBookingSystem.customer.bean.CustomerBean;
import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;
import com.simpana.eventBookingSystem.customer.service.CustomerService;
import com.simpana.eventBookingSystem.event.bean.EventBean;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/customerController")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getListOfCustomer", method = RequestMethod.GET)
	public List<CustomerEntity> getListOfCustomer(HttpServletRequest req, HttpServletResponse res)
			 {

		return customerService.getListOfCustomer();
	}
	
	@RequestMapping(value = "/getListOfCustomersEvents", method = RequestMethod.GET)
	public List<EventBean> getListOfCustomersEvent(HttpServletRequest req, HttpServletResponse res)
			 {

		return customerService.getListOfCustomersEvents();
	}

	@RequestMapping(value = "getCustomerById/{idCustomer}", method = RequestMethod.POST)
	public CustomerBean getCustomerById(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idCustomer") Integer idCustomer) {

		CustomerBean customerBean = null;
		if (idCustomer != 0) {
			customerBean = customerService.getCustomerById(idCustomer);
			if (customerBean != null && !"".equals(customerBean)) {
				return customerBean;
			}
		}
		return customerBean;
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public void createCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestBody CustomerBean customerBean) {
		customerService.createCustomer(customerBean);
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public void updateCustomer(HttpServletRequest req, HttpServletResponse res,
			@RequestBody CustomerBean customerBean) {
		customerService.updateCustomer(customerBean);
	}

	@RequestMapping(value = "/deleteCustomer{idCustomer}", method = RequestMethod.DELETE)
	public void deleteCustomer(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idCustomer") Integer idCustomer) {
		customerService.deleteCustomer(idCustomer);
	}

}
