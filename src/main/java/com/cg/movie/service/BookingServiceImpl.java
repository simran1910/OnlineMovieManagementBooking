package com.cg.movie.service;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.BookingDto;
import com.cg.movie.dao.IBookingDao;
import com.cg.movie.dao.IShowDao;
import com.cg.movie.entity.Booking;
import com.cg.movie.entity.Show;
import com.cg.movie.exceptions.BookingException;
import com.cg.movie.exceptions.ShowException;
import com.cg.movie.util.MovieConstants;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao bookingDao;
	@Autowired
	private IShowDao showDao;

	@Override
	public Booking addBooking(BookingDto bookingDto) throws ShowException, BookingException {
		Booking booking=new Booking();
		Optional<Show> optShow= showDao.findById(bookingDto.getShowId());
		if(!optShow.isPresent())
			throw new ShowException(MovieConstants.SHOW_NOT_FOUND);
		Show show=optShow.get();
		if(show.getSeats()<= MovieConstants.AVAILABLE_SEATS_ZERO)
			throw new BookingException(MovieConstants.NO_SEATS_AVAILABE);
		if(bookingDto.getNoOfTkts()>show.getSeats())
			throw new BookingException(MovieConstants.NO_SEATS_AVAILABE);
	
		int count= bookingDao.getMaxId(bookingDto.getShowId())+MovieConstants.INCREMENT_BY_ONE;
		
		booking.setBookingId(bookingDto.getShowId()+MovieConstants.EMPTY+count);
		booking.setBookingDate(LocalDate.now());
		booking.setContact(bookingDto.getContact());
		booking.setUserName(bookingDto.getUserName());
		booking.setNoOfTkts(bookingDto.getNoOfTkts());
		booking.setTotalCost(MovieConstants.COST_PER_TICKET* bookingDto.getNoOfTkts());
		booking.setShow(show);
		booking.setBookFlag(MovieConstants.BOOKING_CONFIRMED);
		
		show.setSeats(show.getSeats()-bookingDto.getNoOfTkts());
		showDao.save(show);
		bookingDao.save(booking);

		return bookingDao.save(booking);
	}

	@Override
	public String cancelBooking(String bookingId) throws BookingException {
		Optional<Booking> booking =bookingDao.findById(bookingId);
		if(!booking.isPresent()||booking==null) {
			throw new BookingException(MovieConstants.BOOKING_NOT_FOUND);
		}
		Booking book= booking.get();
		book.setBookFlag(MovieConstants.BOOKING_CANCELLED);
		Show show= book.getShow();
		show.setSeats(show.getSeats()+book.getNoOfTkts());
		showDao.save(show);
		bookingDao.save(book);
		bookingDao.deleteById(bookingId);;
		return MovieConstants.TICKET_CANCELLED;
	}
	

	/*@Override
	public List<Booking> getBooking() throws BookingException {
		List<Booking> blist = bookingDao.findAll();
		if(blist.isEmpty())
			throw new BookingException("Booking not found");
		blist.sort((b1, b2) -> (b1.getUserName()).compareTo(b2.getUserName()));
		
		return blist;
	}*/

	/*	@Override
	public List<Booking> findByShow(String show) throws BookingException {
		List<Booking> bookingList = bookingDao.findByShow(show);
	if (bookingList.isEmpty())
		throw new BookingException("Booking not found");
	return bookingList;
	}*/

}
