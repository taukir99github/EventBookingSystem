package com.simpana.eventBookingSystem.parameter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simpana.eventBookingSystem.parameter.entity.ParameterEntity;

@Repository
public interface ParameterRepository extends CrudRepository<ParameterEntity, Integer>{

	@Query("from ParameterEntity where parameter_Key=:key")
	ParameterEntity findByParameter_Key(String key);

}
