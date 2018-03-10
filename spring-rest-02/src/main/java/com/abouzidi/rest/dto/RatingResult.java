package com.abouzidi.rest.dto;

import java.util.Map;

public class RatingResult {

	private long totalRating;
	private Map<Integer,Long> ratingResults;

	public long getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(long totalRating) {
		this.totalRating = totalRating;
	}

	public Map<Integer, Long> getRatingResults() {
		return ratingResults;
	}

	public void setRatingResults(Map<Integer, Long> ratingResults) {
		this.ratingResults = ratingResults;
	}
}
