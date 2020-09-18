package com.cg;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.entity.Booking;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.service.IBookingService;

@SpringBootTest
class TestGetBookingService {
@Autowired
IBookingService service;

	@Test
	public void testByContact1() throws BookingException {
	List<Booking> blist=service.getBooking("9090909090");
	Assertions.assertTrue(!blist.isEmpty());
	}
	
	@Test
	public void testByContact2() throws BookingException {
	List<Booking> blist=service.getBooking("8080808080");
	Assertions.assertTrue(!blist.isEmpty());
	}

	@Test
	public void testByContactNotFound() throws BookingException {
	Assertions.assertThrows(BookingException.class,()->service.getBooking("1000000000"));
	}
}
