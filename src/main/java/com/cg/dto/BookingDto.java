package com.cg.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BookingDto {

	private int showId;
	private int noOfTkts;
	@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)")
	@Size(min = 3)
	private String userName;
	@Size(min = 10 , max=10)
	private String contact;
	
	public BookingDto() {
		
	}

	public BookingDto(int showId, int noOfTkts,
			@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)") @Size(min = 3) String userName,
			@Size(min = 10, max = 10) String contact) {
		super();
		this.showId = showId;
		this.noOfTkts = noOfTkts;
		this.userName = userName;
		this.contact = contact;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getNoOfTkts() {
		return noOfTkts;
	}

	public void setNoOfTkts(int noOfTkts) {
		this.noOfTkts = noOfTkts;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	

	
}
