package com.abouzidi.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO {

	private long id;

	private String title;

	private String author;

	@JsonIgnore
	private Date createdAt = new Date();

	private Collection<RatingDTO> ratings = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Collection<RatingDTO> getRatings() {
		return ratings;
	}

	public void setRatings(Collection<RatingDTO> ratings) {
		this.ratings = ratings;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author=" + author + ", createdAt=" + createdAt
				+ ", ratings=" + ratings + "]";
	}
}
