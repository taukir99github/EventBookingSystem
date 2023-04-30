package com.simpana.eventBookingSystem.roomAndhall.service;

import java.util.List;

import com.simpana.eventBookingSystem.roomAndhall.bean.RoomAndHallBean;

public interface RoomAndHallService {
	
	public List<RoomAndHallBean> getListOfRoomAndHall(RoomAndHallBean roomAndHallBean, Integer limit);

	public void createRoomAndHall(RoomAndHallBean roomAndHallBean);

	public void updateRoomAndHall(RoomAndHallBean roomAndHallBean);

	public void deleteRoomAndHall(Integer idRoomAndHall);

	RoomAndHallBean getRoomAndHallById(Integer idRoomAndHall);
}
