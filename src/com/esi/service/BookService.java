package com.esi.service;

import com.esi.dao.IReservationDao;
import com.esi.dao.IRoomDao;
import com.esi.model.Guest;
import com.esi.model.Reservation;
import com.esi.model.Room;

import java.util.Date;


public class BookService {
	
	private IRoomDao iRoomDao;
	private IReservationDao iReservationDao;
	
	





	public BookService(IRoomDao iRoomDao, IReservationDao iReservationDao) {
		this.iRoomDao = iRoomDao;
		this.iReservationDao = iReservationDao;
	}

	
	

	public BookService(IReservationDao iReservationDao) {
		super();
		this.iReservationDao = iReservationDao;
	}




	public boolean bookRoom(Room room, Date date_in, Date date_out, Guest guest)  {
		
		if((iRoomDao.isAvailable(room, date_in,date_out))) {
			Reservation reservation = new Reservation(date_in,date_out,room,guest);
			return iReservationDao.createReservation(reservation);
		}
		
		return false;
	}
	
	
	public boolean cancelReservation(int id) {
		
		Reservation reservation = iReservationDao.findReservation(id);
		if(reservation!=null) {
			return iReservationDao.cancelReservation(reservation);
		}
	
		return false;
	}
	
	}
	

