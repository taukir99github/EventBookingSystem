package com.simpana.eventBookingSystem.parameter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simpana.eventBookingSystem.parameter.entity.ParameterEntity;
import com.simpana.eventBookingSystem.parameter.service.ParameterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/parameterController")
public class ParameterController {

	@Autowired
	ParameterService parameterService;

	@RequestMapping(value = "/getListOfParameter", method = RequestMethod.GET)
	public List<ParameterEntity> getListOfCustomer(HttpServletRequest req, HttpServletResponse res)
			 {

		return parameterService.getListOfParameter();
	}
	

	@RequestMapping(value = "getParameterById/{idParameter}", method = RequestMethod.POST)
	public ParameterEntity getParameterById(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idParameter") Integer idParameter) {

		ParameterEntity parameterEntity= null;
		if (idParameter != 0) {
			parameterEntity = parameterService.getParameterById(idParameter);
			if (parameterEntity != null && !"".equals(parameterEntity)) {
				return parameterEntity;
			}
		}
		return parameterEntity;
	}

	@RequestMapping(value = "/createParameter", method = RequestMethod.POST)
	public void createParameter(HttpServletRequest req, HttpServletResponse res,
			@RequestBody ParameterEntity parameterEntity) {
		parameterService.createParameter(parameterEntity);
	}

	@RequestMapping(value = "/updateParameter", method = RequestMethod.PUT)
	public void updateParameter(HttpServletRequest req, HttpServletResponse res,
			@RequestBody ParameterEntity parameterEntity) {
		parameterService.updateParameter(parameterEntity);
	}

	@RequestMapping(value = "/deleteParameter{idParameter}", method = RequestMethod.DELETE)
	public void deleteParameter(HttpServletRequest req, HttpServletResponse res,
			@PathVariable("idParameter") Integer idParameter) {
		parameterService.deleteParameter(idParameter);
	}

}
