package com.abouzidi.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abouzidi.rest.dto.RatingResult;
import com.abouzidi.rest.service.RatingService;

@RestController
public class ComputeResultController {

	@Autowired
	private RatingService ratingService;

	@RequestMapping(value = "/computeresult", method = RequestMethod.GET)
	public ResponseEntity<?> computeResult(@RequestParam Long bookId) {
		RatingResult result = ratingService.computeResult(bookId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
