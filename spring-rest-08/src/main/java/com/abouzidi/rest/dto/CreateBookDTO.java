package com.abouzidi.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class CreateBookDTO {
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String author;
	
	private Date createdAt = new Date();

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
