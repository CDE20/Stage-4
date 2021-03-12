package com.cognizant.MovieCruiser.model;

import java.util.Date;
import java.util.List;

public class movie {
	private String moviename;
	private String boxoffice;
	private String genere;
	private String status;
	private Date launch;
	private String favourite;
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLaunch() {
		return launch;
	}
	public void setLaunch(Date launch) {
		this.launch = launch;
	}
	public String getFavourite() {
		return favourite;
	}
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	
	

}
