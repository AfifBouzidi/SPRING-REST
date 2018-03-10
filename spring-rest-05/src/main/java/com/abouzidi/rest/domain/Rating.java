package com.abouzidi.rest.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rating {

	@SequenceGenerator(name = "rating_gen", sequenceName = "rating_seq")
	@Id
	@GeneratedValue(generator = "rating_gen")
	private long id;

	private int mark;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ratingDate;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BOOK_ID")
	private Book book;

	public Rating() {

	}

	public Rating(int mark) {
		this.mark = mark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
