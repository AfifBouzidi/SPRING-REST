package com.abouzidi.rest.dto;

public class RatingDTO {

	private long id;

	private int mark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "RatingDTO [id=" + id + ", mark=" + mark + "]";
	}
}
