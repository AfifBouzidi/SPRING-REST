package com.abouzidi.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;

public interface BookService {

	public BookDTO createBookForRating(CreateBookDTO createBookDTO);

	public void updateBook(UpdateBookDTO updateBookDTO);

	public BookDTO findBookById(long bookId);

	public Page<BookDTO> findAllBooks(Pageable pageable);

	public void deleteBookById(long bookId);

}
