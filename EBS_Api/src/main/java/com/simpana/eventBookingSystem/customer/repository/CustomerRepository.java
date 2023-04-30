package com.simpana.eventBookingSystem.customer.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simpana.eventBookingSystem.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

	CustomerEntity findByMdate(Date date);

}
