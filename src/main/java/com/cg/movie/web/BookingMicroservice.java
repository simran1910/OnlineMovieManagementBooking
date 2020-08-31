package com.cg.movie.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.BookingDto;
import com.cg.dto.BookingMessage;
import com.cg.movie.entity.Booking;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;
import com.cg.movie.exceptions.ValidateBookingException;
import com.cg.movie.service.IBookingService;
import com.cg.movie.util.MovieConstants;

@RestController 
@CrossOrigin(origins= {"http://localhost:4200"})
public class BookingMicroservice {
	@Autowired
	private IBookingService bookingService;

	
	//-------------Add Booking-------------//
	
	@PostMapping(MovieConstants.ADD_BOOKING_URL)
	public BookingMessage addBooking(@Valid @RequestBody BookingDto bookingdto, BindingResult br) throws ValidateBookingException, BookingException, ShowException {
		if(br.hasErrors()) {
			throw new ValidateBookingException(br.getFieldErrors());
		}
		Booking booking= bookingService.addBooking(bookingdto);
		
		return new BookingMessage(MovieConstants.TICKET_BOOKED + booking.getBookingId());
	}
	

	
	//-------------Cancel Booking-------------//
	
	@DeleteMapping(MovieConstants.CANCEL_BOOKING_URL)
	public String cancelBooking(@PathVariable ("bookingid") String bookingId) throws BookingException{
		bookingService.cancelBooking(bookingId);
		return MovieConstants.TICKET_CANCELLED;
	}	
	
	
		
/*	//-------------Get all Booking-------------//
	
	@GetMapping("allbooking")
	public List<Booking> allBooking() throws BookingException{
		List<Booking> blist = bookingService.getBooking();
		return blist;
	}*/
	
	
	//-------------Find Booking by show-------------//
	
	/*@GetMapping("findbyshow/{sname}")
	public List<Booking> findByShow(@PathVariable("sname") String show) throws BookingException{
		List<Booking> blist = bookingService.findByShow(show);
		return blist;
	}*/

	
	
}
