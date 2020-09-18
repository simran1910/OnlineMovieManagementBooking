package com.cg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.exceptions.BookingException;
import com.cg.movie.service.BookingServiceImpl;

@SpringBootTest
public class TestCancelBookingService {
	@Autowired
	private BookingServiceImpl service;
	@Test
	public void testCancelBooking1() throws BookingException
	{
		service.cancelBooking("133");
		
	}
	@Test
	public void testCancelBooking2()
	{
		Assertions.assertThrows(BookingException.class, ()->service.cancelBooking("100"));
	}

}
