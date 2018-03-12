package com.abouzidi.rest.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.BookRatingMapper;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;
import com.abouzidi.rest.exception.ResourceNotFoundException;
import com.abouzidi.rest.repository.BookRepository;
import com.abouzidi.rest.service.BookService;
import com.abouzidi.rest.util.Util;

@Component
public class DefaultBookService implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookRatingMapper bookRatingMapper;

	@Override
	public BookDTO createBookForRating(CreateBookDTO createBookDTO) {
		Book book = new Book(createBookDTO.getTitle(), createBookDTO.getAuthor());
		bookRepository.save(book);
		return bookRatingMapper.asBookDTO(book);
	}

	@Override
	public void updateBook(UpdateBookDTO updateBookDTO) {
		Optional<Book> optionalBook = bookRepository.findById(updateBookDTO.getId());
		if (!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + updateBookDTO.getId() + " not found");
		}
		Book book = optionalBook.get();
		book.setAuthor(updateBookDTO.getAuthor());
		book.setTitle(updateBookDTO.getTitle());
		book.setEditedAt(updateBookDTO.getEditedAt());
		bookRepository.save(book);
	}

	@Override
	public BookDTO findBookById(long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		return bookRatingMapper.asBookDTO(optionalBook.get());
	}

	@Override
	public Page<BookDTO> findAllBooks(Pageable pageable) {
		Page<Book> pageBook = bookRepository.findAll(pageable);
		List<BookDTO> bookDtos = new ArrayList<>(bookRatingMapper.asBookCollectionDTO(pageBook.getContent()));
		return new PageImpl<>(bookDtos, pageable, pageBook.getTotalElements());
	}

	@Override
	public void deleteBookById(long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		bookRepository.delete(optionalBook.get());
	}
}
