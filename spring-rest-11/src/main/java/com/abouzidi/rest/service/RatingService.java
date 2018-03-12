package com.abouzidi.rest.service;

import com.abouzidi.rest.dto.CreateRatingDTO;
import com.abouzidi.rest.dto.RatingDTO;
import com.abouzidi.rest.dto.RatingResult;

public interface RatingService {

	public RatingDTO createRating(CreateRatingDTO createRatingDTO);

	public Iterable<RatingDTO> findAllRatingsByBookId(long bookId);

	public RatingResult computeResult(long bookId);

}
