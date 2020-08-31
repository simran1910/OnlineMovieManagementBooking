package com.cg.movie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="abes_movie_movie")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	private int movieId;
	@Column(name="movie_name", length=25)
	private String movieName;
	@Column(name="language", length=25)
	private String language;
	@Column(name="director", length=25)
	private String director;
	@Column(name="genre", length=25)
	private String genre;
	@Column(name="active", length=25)
	private int active;
	
	@Column(name="releaseDt")
	private LocalDate releaseDt;
	
	@Column(name="movie_desc")
	private String movieDesc;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public LocalDate getReleaseDt() {
		return releaseDt;
	}
	public void setReleaseDt(LocalDate releaseDt) {
		this.releaseDt = releaseDt;
	}
	
	
	
	
	
	
}

