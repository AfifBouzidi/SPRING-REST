package com.abouzidi.rest.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO extends ResourceSupport{

	private long bookDTOId;

	private String title;

	private String author;

	@JsonIgnore
	private Date createdAt = new Date();

	private Collection<RatingDTO> ratings = new ArrayList<>();

	public Long getBookDTOId() {
		return bookDTOId;
	}

	public void setBookDTOId(Long id) {
		this.bookDTOId = id;
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
		return "BookDTO [id=" + bookDTOId + ", title=" + title + ", author=" + author + ", createdAt=" + createdAt
				+ ", ratings=" + ratings + "]";
	}
}
