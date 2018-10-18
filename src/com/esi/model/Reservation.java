package com.esi.model;

import java.util.Date;

public class Reservation {
	
	

	private int id;
	private Date date_in;
	private Date date_out;
	private Room room;
	private Guest guest;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_in() {
		return date_in;
	}

	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}

	public Date getDate_out() {
		return date_out;
	}

	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Reservation(Date date_in, Date date_out, Room room, Guest guest) {
		super();
		this.date_in = date_in;
		this.date_out = date_out;
		this.room = room;
		this.guest = guest;
	}
	
	 @Override public boolean equals(Object other) {
	    boolean result = false;
	    if (other instanceof Reservation) {
	        Reservation that = (Reservation) other;
	        result = 
	        (this.date_in == that.getDate_in() && this.date_out == that.date_out
	        && this.id == that.getId()
	        && this.guest.equals(that.guest)
	        && this.room.equals(that.room));
	    }
	    return result;
	}

}
