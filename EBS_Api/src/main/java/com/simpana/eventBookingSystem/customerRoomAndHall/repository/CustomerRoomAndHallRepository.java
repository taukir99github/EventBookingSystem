package com.simpana.eventBookingSystem.customerRoomAndHall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simpana.eventBookingSystem.customerRoomAndHall.entity.CustomerRoomAndHallEntity;


@Repository
public interface CustomerRoomAndHallRepository extends CrudRepository<CustomerRoomAndHallEntity, Integer>{

}
