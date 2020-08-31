package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.movie.entity.Show;

@Repository
public interface IShowDao extends JpaRepository<Show, Integer> {

	
}
