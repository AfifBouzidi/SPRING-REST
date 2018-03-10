package com.abouzidi.rest.service;

import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;

public interface BookService {

	public BookDTO createBookForRating(CreateBookDTO createBookDTO);

	public void updateBook(UpdateBookDTO updateBookDTO);

	public BookDTO findBookById(long bookId);

	public Iterable<BookDTO> findAllBooks();

	public void deleteBookById(long bookId);

}
