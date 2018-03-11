package com.abouzidi.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRatingBookClient implements CommandLineRunner {

	@Autowired
	BookRatingCient bookRatingCient;

	@Override
	public void run(String... args) throws Exception {
		///////get book by ID////////
		BookDTO book = bookRatingCient.getBookById(1l);
		System.out.println(book.toString());
		///////create book////////		
		BookDTO bookOne=new BookDTO();
		bookOne.setAuthor("AFB");
		bookOne.setTitle("Math");
		URI uri=bookRatingCient.createBook(bookOne);
		System.out.println(uri.getPath());
		/////////update book/////////////
		book.setTitle(book.getTitle()+" (EDITION 2018)");
		bookRatingCient.updateBook(book);
		///////////////pagination////////
		PageWrapper<BookDTO> page =bookRatingCient.getAllBooks(0,5);
		System.out.println(page.getContent().size());
		//////////////////delete/////////////
		bookRatingCient.deleteBook(2l);

	}

}
