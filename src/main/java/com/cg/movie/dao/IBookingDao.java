package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Booking;
@Repository
public interface IBookingDao extends JpaRepository<Booking, String> {

	@Query(value= "select count(bookingId) from Booking b where b.show.showId=:showid")
	public Integer getMaxId(@Param ("showid") int showId);

	/*@Query("from Booking b inner join fetch b.show s where s.showName like :sname or s.screenName like :sname")
	public List<Booking> findByShow(@Param("sname") String show);
	*/

	

}
