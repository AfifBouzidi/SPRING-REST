package com.abouzidi.rest.controller;

import java.net.URI;
import javax.validation.Valid;
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
import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.CreateBookDTO;
import com.abouzidi.rest.dto.UpdateBookDTO;
import com.abouzidi.rest.exception.ErrorDetail;
import com.abouzidi.rest.service.BookService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@RestController
@Api(value = "books", description = "Book API")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieves all the books", response=Book.class,responseContainer="List")
	public ResponseEntity<Iterable<BookDTO>> getAllBooks() {
		Iterable<BookDTO> allBooks = bookService.findAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Book", notes="The newly created book Id will be sent in the location response header", response = Void.class)
	@ApiResponses(value = {@ApiResponse(code=201, message="Poll Created Successfully",response=Void.class),	@ApiResponse(code=500, message="Error creating Poll",response=ErrorDetail.class) } )
	public ResponseEntity<?> createBook(@Valid @RequestBody CreateBookDTO book) {
		BookDTO dto = bookService.createBookForRating(book);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newBookUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		responseHeaders.setLocation(newBookUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieves a Book associated with the bookId", response=Book.class)
	public ResponseEntity<?> getBook(@PathVariable Long bookId) {
		BookDTO book = bookService.findBookById(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Updates a Book", notes="Updates a Book associated with the bookId", response = Void.class)
	public ResponseEntity<?> updateBook(@Valid @RequestBody UpdateBookDTO book, @PathVariable Long bookId) {
		bookService.updateBook(book);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deletes a Book", notes="Deletes a Book associated with the bookId", response = Void.class)
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
		bookService.deleteBookById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
