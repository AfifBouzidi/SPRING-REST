package com.abouzidi.rest.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.domain.Rating;
import com.abouzidi.rest.dto.BookRatingMapper;
import com.abouzidi.rest.dto.CreateRatingDTO;
import com.abouzidi.rest.dto.RatingDTO;
import com.abouzidi.rest.dto.RatingResult;
import com.abouzidi.rest.exception.ResourceNotFoundException;
import com.abouzidi.rest.repository.BookRepository;
import com.abouzidi.rest.repository.RatingRepository;
import com.abouzidi.rest.service.RatingService;

@Component
public class DefaultRatingService implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookRatingMapper bookRatingMapper;

	@Override
	public RatingDTO createRating(CreateRatingDTO createRatingDTO) {
		Optional<Book> optionalBook = bookRepository.findById(createRatingDTO.getBookId());
		if (!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + createRatingDTO.getBookId() + " not found");
		}
		Book book = optionalBook.get();
		Rating rating = new Rating(createRatingDTO.getMark());
		book.getRatings().add(rating);
		rating.setBook(book);
		ratingRepository.save(rating);
		return bookRatingMapper.asRatingDTO(rating);
	}

	@Override
	public Iterable<RatingDTO> findAllRatingsByBookId(long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		Book book = optionalBook.get();
		return bookRatingMapper.asRatingCollectionDTO(book.getRatings());
	}

	@Override
	public RatingResult computeResult(long bookId) {
		RatingResult ratingResult = new RatingResult();
		Iterable<RatingDTO> ratings = this.findAllRatingsByBookId(bookId);
		Map<Integer, Long> map = StreamSupport.stream(ratings.spliterator(), false)
				.collect(Collectors.groupingBy((RatingDTO r) -> r.getMark(), Collectors.counting()));
		ratingResult.setRatingResults(map);
		ratingResult.setTotalRating(StreamSupport.stream(ratings.spliterator(), false).count());
		return ratingResult;
	}

}
