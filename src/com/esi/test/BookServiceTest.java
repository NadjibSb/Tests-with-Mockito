package com.esi.test;

import com.esi.dao.*;
import com.esi.model.*;
import com.esi.service.*;


import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    public void bookRoom() throws ParseException {

        Room room = new Room(1, "RoomTest", 4);
        Guest guest = new Guest("Nadjib", "Souab");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date_in = sdf.parse("07-10-2019");
        Date date_out = sdf.parse("29-01-2019");

        Reservation reservation = new Reservation(date_in, date_out, room, guest);

        IRoomDao IRoomD = Mockito.mock(IRoomDao.class);
        when(IRoomD.isAvailable(room, date_in, date_out)).thenReturn(true);

        IReservationDao IResD = Mockito.mock(IReservationDao.class);
        when(IResD.createReservation(reservation)).thenReturn(true);

        BookService bookService = new BookService(IRoomD, IResD);

        assertTrue(bookService.bookRoom(room, date_in, date_out, guest));

    }

    @Test
    public void cancelReservation() throws ParseException {

        Room room = new Room(1, "RoomTest", 4);
        Guest guest = new Guest("Nadjib", "Souab");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date_in = sdf.parse("07-10-2019");
        Date date_out = sdf.parse("29-01-2019");
        Reservation reservation = new Reservation(date_in, date_out, room, guest);

        IReservationDao IResD = Mockito.mock(IReservationDao.class);
        when(IResD.findReservation(1)).thenReturn(reservation);
        when(IResD.cancelReservation(reservation)).thenReturn(true);


        BookService bookService = new BookService( IResD);

        assertTrue(bookService.cancelReservation(1));


    }


}