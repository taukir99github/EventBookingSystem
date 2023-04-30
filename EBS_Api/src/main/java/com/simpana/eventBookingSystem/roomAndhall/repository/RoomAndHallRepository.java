package com.simpana.eventBookingSystem.roomAndhall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simpana.eventBookingSystem.roomAndhall.entity.RoomAndHallEntity;


@Repository
public interface RoomAndHallRepository extends CrudRepository<RoomAndHallEntity, Integer> {

}
