package com.abouzidi.rest.service.impl;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.BookRatingMapper;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;
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
			return;
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
			return null;
		}
		return bookRatingMapper.asBookDTO(optionalBook.get());
	}

	@Override
	public Collection<BookDTO> findAllBooks() {
		return bookRatingMapper.asBookCollectionDTO(Util.toList(bookRepository.findAll()));
	}

	@Override
	public void deleteBookById(long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			return;
		}
		bookRepository.delete(optionalBook.get());
	}

}
