package com.abouzidi.rest;

import java.net.URI;

public interface BookRatingCient {

	BookDTO getBookById(long bookId);

	URI createBook(BookDTO book);

	void updateBook(BookDTO book);
	
	PageWrapper<BookDTO> getAllBooks(int page, int size);
	
	void deleteBook(Long bookId);
}