package com.wokshop2.entity;

public class Movie {
	private String title;
	private String director;
	private String genre;
	private String actor;
	private int releaseYear;
	private int runTime;
	private String rating;
	
	public Movie(String title, String director, String genre, String actor) {		
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.actor = actor;
	}
	public Movie(String title, String director, String genre, String actor, String rating) {
		this(title, director, genre,actor);
		this.rating = rating;
	}
	public Movie(String title, String director, String genre, String actor, int releaseYear, int runTime) {
		this(title, director, genre,actor);
		this.releaseYear = releaseYear;
		this.runTime = runTime;
	}
	public Movie(String title, String director, String genre, String actor, int releaseYear, int runTime,
			String rating) {
		this(title, director, genre,actor, releaseYear, runTime);		
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return director;
	}
	public String getGenre() {
		return genre;
	}
	public String getActor() {
		return actor;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public int getRunTime() {
		return runTime;
	}
	public String getRating() {
		return rating;
	}
	@Override
	public String toString() {
		String str = String.format("%-20s\t%-7s\t%-7s\t%-7s\t", title, director, genre, actor);
		 
		if(releaseYear==0) {
			str += String.format("%-4s\t", "N/A");
		}else {
			str += String.format("%-4s³â\t", String.valueOf(releaseYear));
		}
		if(runTime==0) {
			str += String.format("%-3s\t", "N/A");
		}else {
			str += String.format("%-3sºÐ\t", String.valueOf(runTime));
		}
		if(rating==null) {
			str += String.format("%-7s\n", "N/A");
		}else {
			str += String.format("%-7s\n", rating);
		}
		return str;
				 
	}
	
	
	
}
