package com.abouzidi.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;
import com.abouzidi.rest.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<Iterable<BookDTO>> getAllBooks() {
		Iterable<BookDTO> allBooks = bookService.findAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<?> createBook(@RequestBody CreateBookDTO book) {
		BookDTO dto = bookService.createBookForRating(book);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newBookUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		responseHeaders.setLocation(newBookUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<?> getBook(@PathVariable Long bookId) {
		BookDTO book = bookService.findBookById(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@RequestBody UpdateBookDTO book, @PathVariable Long bookId) {
		bookService.updateBook(book);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
		bookService.deleteBookById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
