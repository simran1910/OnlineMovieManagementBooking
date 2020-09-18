package com.cg;



import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.BookingDto;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;
import com.cg.movie.service.IBookingService;

@SpringBootTest
class TestAddBookingService {
@Autowired
IBookingService service;


@Test
public void testAddBooking1() throws BookingException, ShowException {
	
	BookingDto dto = new BookingDto(32, 4, "Anand","111111555");
	service.addBooking(dto);

}

@Test
public void testAddBooking2() throws BookingException, ShowException {
	BookingDto dto = new BookingDto(100, 2, "kareem","4444444444");
	assertThrows(ShowException.class, ()->service.addBooking(dto));
}

}
