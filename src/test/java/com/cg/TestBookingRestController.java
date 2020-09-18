package com.cg;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.BookingDto;
import com.cg.movie.entity.Booking;


public class TestBookingRestController {
	private RestTemplate rt=new RestTemplate();
	
	
    @Test
   	public void testGetBookingByContact1()
   	{
       	String url= "http://localhost:8082/booking/getbooking/8080808080";
       	ResponseEntity<List<Booking>> resp=rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {
		});
		assertFalse(resp.getBody().isEmpty());
   	}
    @Test
    public void testGetBookingByContact2()
    {
    	String url= "http://localhost:8082/booking/getbooking/9090909090";
    	ResponseEntity<List<Booking>> resp=rt.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {
    	});
    	assertFalse(resp.getBody().isEmpty());
    }

    @Test
   	public void testDeleteBookingByBookingId1()
   	{
       	String url= "http://localhost:8082/booking/cancelbooking/121";
       	ResponseEntity<String> resp=rt.exchange(url, HttpMethod.DELETE, null, String.class);
		String result=(resp.getBody());
   	}
    @Test
	public void testDeleteBookingByBookingId2()
   	{
       	String url= "http://localhost:8082/booking/cancelbooking/131";
      	Assertions.assertThrows(HttpClientErrorException.class, ()->rt.exchange(url, HttpMethod.DELETE, null, String.class));
   	}

    @Test
	public void testAddBooking1()
   	{
       	String url= "http://localhost:8082/booking/addbooking";
       	BookingDto dto=new BookingDto();
       	dto.setShowId(12);
       	dto.setNoOfTkts(2);
       	dto.setUserName("Ramesh");
       	dto.setContact("5555555555");

       	try {
    		String res =rt.postForObject(url, dto, String.class);
    		System.out.println("result " + res);
    		}catch(HttpClientErrorException ex) {
    			System.out.println(ex.getResponseBodyAsString());
    		}
   	}
    @Test
    public void testAddBooking2()
   	{
    	String url= "http://localhost:8082/booking/addbooking";
       	BookingDto dto=new BookingDto();
       	dto.setShowId(12);
       	dto.setNoOfTkts(2);
       	dto.setUserName("Ramesh");
       	dto.setContact("5555555555");
       	Assertions.assertThrows(HttpClientErrorException.class, ()-> rt.exchange(url, HttpMethod.POST, null, String.class));
   	}

}
