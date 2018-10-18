package com.esi.dao;

import com.esi.model.*;

import java.util.Date;


public interface IRoomDao {

	public boolean isAvailable(Room room,Date date_in, Date date_out);

	
}
