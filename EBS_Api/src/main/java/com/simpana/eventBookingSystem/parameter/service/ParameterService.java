package com.simpana.eventBookingSystem.parameter.service;

import java.util.List;

import com.simpana.eventBookingSystem.parameter.entity.ParameterEntity; 

public interface ParameterService {

	public List<ParameterEntity> getListOfParameter();
	
	public void createParameter(ParameterEntity parameterEntity);

	public void updateParameter(ParameterEntity parameterEntity);

	public void deleteParameter(Integer idParameter);
	
	ParameterEntity getParameterById(Integer idParameter);

	public String getValueForParam(String key);
}
