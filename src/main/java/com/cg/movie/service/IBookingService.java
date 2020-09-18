package com.cg.movie.service;

import java.util.List;

import com.cg.dto.BookingDto;
import com.cg.movie.entity.Booking;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;

public interface IBookingService {
	
	public Booking addBooking (BookingDto bookingDto) throws BookingException, ShowException;
	public String cancelBooking(String bookingId) throws BookingException;
	public List<Booking> getBooking(String contact) throws BookingException;
}
