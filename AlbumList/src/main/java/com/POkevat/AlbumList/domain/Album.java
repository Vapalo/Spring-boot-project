package com.POkevat.AlbumList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;









@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String artist;
	
	@NotNull
	@Size(min=1, max=30)
	private String name;
	
	@NotNull(message="Please enter a valid year")
	@Positive(message="Please enter a valid year")
	@Digits(integer = 4, fraction = 0, message="Please enter a valid year")
	private int year;
	
	
	@ManyToOne
	@JoinColumn(name="genreid")
	private Genre genre;


	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Album( String artist, String name, int year, Genre genre) {
		super();
		this.artist = artist;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Album [id=" + id + ", artist=" + artist + ", name=" + name + ", year=" + year + ", genre=" + genre
				+ "]";
	}
	
	
	
	
}
