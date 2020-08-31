package com.cg.movie.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="abes_movie_booking")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	private String bookingId;
	@Column(name="booking_date")
	private LocalDate bookingDate;
	@Column(name="no_of_tkts")
	private int noOfTkts;
	@Column(name="total_cost")
	private double totalCost;
	@Column(name="user_name", length=25)
	private String userName;
	@Column(name="contact", length=10)
	private String contact;
	
	@Transient
	private boolean bookFlag;
	
	@ManyToOne
	@JoinColumn(name="show_id", referencedColumnName = "show_id")
	private Show show = new Show(); 

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfTkts() {
		return noOfTkts;
	}

	public void setNoOfTkts(int noOfTkts) {
		this.noOfTkts = noOfTkts;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public boolean isBookFlag() {
		if(bookingDate.compareTo(LocalDate.now()) >= 0) this.bookFlag=true;
		else this.bookFlag=false;
		return this.bookFlag;
	}

	public boolean getBookFlag() {
		if(bookingDate.compareTo(LocalDate.now()) >= 0) this.bookFlag=true;
		else this.bookFlag=false;
		return this.bookFlag;
	}
	public void setBookFlag(boolean bookFlag) {
		this.bookFlag = bookFlag;
	}
	
	
	
	
	
	}

