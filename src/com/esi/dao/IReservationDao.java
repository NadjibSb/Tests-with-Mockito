package com.esi.dao;

import com.esi.model.Reservation;

public interface IReservationDao {
	
	public boolean createReservation(Reservation reservation);

	public Reservation findReservation(int id);

	public boolean cancelReservation(Reservation reservation);

}
