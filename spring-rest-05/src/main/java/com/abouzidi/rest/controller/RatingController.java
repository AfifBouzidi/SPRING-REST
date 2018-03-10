package com.abouzidi.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.abouzidi.rest.dto.CreateRatingDTO;
import com.abouzidi.rest.dto.RatingDTO;
import com.abouzidi.rest.service.RatingService;
import com.wordnik.swagger.annotations.Api;

@RestController
@Api(value = "ratings", description = "Rating API")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value = "/books/{bookId}/ratings", method = RequestMethod.POST)
	public ResponseEntity<?> createRating(@PathVariable Long bookId, @Valid @RequestBody CreateRatingDTO rating) {
		rating.setBookId(bookId);
		RatingDTO ratingDTO = ratingService.createRating(rating);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ratingDTO.getId()).toUri());
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/books/{bookId}/ratings", method = RequestMethod.GET)
	public ResponseEntity<Iterable<RatingDTO>> getAllRatings(@PathVariable Long bookId) {
		Iterable<RatingDTO> allRatings = ratingService.findAllRatingsByBookId(bookId);
		return new ResponseEntity<>(allRatings, HttpStatus.OK);
	}

}
