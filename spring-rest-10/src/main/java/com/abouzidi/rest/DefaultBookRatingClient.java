package com.abouzidi.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DefaultBookRatingClient implements BookRatingCient {

	private static final String RATING_BOOK_URI = "http://localhost:8080/books";

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abouzidi.rest.BookRatingCient#getBookById(long)
	 */
	@Override
	public BookDTO getBookById(long bookId) {
		return restTemplate.getForObject(RATING_BOOK_URI + "/{bookId}", BookDTO.class, bookId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abouzidi.rest.BookRatingCient#createPoll(com.abouzidi.rest.BookDTO)
	 */
	@Override
	public URI createBook(BookDTO book) {
		return restTemplate.postForLocation(RATING_BOOK_URI, book);
	}

	@Override
	public void updateBook(BookDTO book) {
		restTemplate.put(RATING_BOOK_URI + "/{bookId}", book, book.getId());
	}

	@Override
	public PageWrapper<BookDTO> getAllBooks(int page, int size) {
		ParameterizedTypeReference<PageWrapper<BookDTO>> responseType = new ParameterizedTypeReference<PageWrapper<BookDTO>>() {
		};
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(RATING_BOOK_URI).queryParam("page", page).queryParam("size", size);
		ResponseEntity<PageWrapper<BookDTO>> responseEntity = restTemplate.exchange(builder.build().toUri(),HttpMethod.GET, null, responseType);
		return responseEntity.getBody();
	}

	@Override
	public void deleteBook(Long bookId) {
		restTemplate.delete(RATING_BOOK_URI + "/{bookId}", bookId);		
	}

}
