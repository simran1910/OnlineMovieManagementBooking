package com.cg.movie.service;

import com.cg.dto.BookingDto;
import com.cg.movie.entity.Booking;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;

public interface IBookingService {
	
	public Booking addBooking (BookingDto bookingDto) throws BookingException, ShowException;
	public String cancelBooking(String bookingId) throws BookingException;
	//List<Booking> getBooking() throws BookingException;
	//public List<Booking> findByShow(String show) throws BookingException;

}
