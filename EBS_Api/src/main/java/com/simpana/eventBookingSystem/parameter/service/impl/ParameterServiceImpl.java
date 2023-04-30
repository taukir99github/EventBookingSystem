package com.simpana.eventBookingSystem.parameter.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpana.eventBookingSystem.parameter.entity.ParameterEntity;
import com.simpana.eventBookingSystem.parameter.repository.ParameterRepository;
import com.simpana.eventBookingSystem.parameter.service.ParameterService;

@Service
public class ParameterServiceImpl implements ParameterService{
	
	@Autowired
	ParameterRepository parameterRepository;
	
	LocalDateTime dateTime = LocalDateTime.now();

	@Override
	public List<ParameterEntity> getListOfParameter() {
		List<ParameterEntity> listOfParameterEntity = (List<ParameterEntity>) parameterRepository.findAll();
		
		
		return listOfParameterEntity;
	}

	@Override
	public ParameterEntity getParameterById(Integer idParameter) {
		Optional<ParameterEntity> parameterEntity = parameterRepository.findById(idParameter);
		if (parameterEntity.isPresent()) {
			return parameterEntity.get();
		}
		return null;
	}

	@Override
	public void createParameter(ParameterEntity parameterEntity) {
		// TODO Auto-generated method stub
		if (parameterEntity != null) {
			LocalDateTime dateTime = LocalDateTime.now();
			parameterRepository.save(parameterEntity);

		}
	}

	@Override
	public void updateParameter(ParameterEntity parameterEntity) {

		if (parameterEntity != null) {
			parameterRepository.save(parameterEntity);
		}
	}

	@Override
	public void deleteParameter(Integer idParameter) {

		if (idParameter != null) {
			parameterRepository.deleteById(idParameter);
		}
	}
	
	@Override
	public String getValueForParam(String key) {

		if (key != null) {
			ParameterEntity param = parameterRepository.findByParameter_Key(key);
			if(param !=null ) {
				return param.getParameter_Value();
			}
			
		}
		return null;
	}



}
