package com.abouzidi.rest.service.impl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.dto.BookDTO;
import com.abouzidi.rest.dto.BookRatingMapper;
import com.abouzidi.rest.repository.BookRepository;
import com.abouzidi.rest.service.BookService;

@RunWith(SpringRunner.class)
public class DefaultBookServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {
		@Bean
		public BookService bookService() {
			return new DefaultBookService();
		}
	}

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private BookRatingMapper bookRatingMapper;

	@Before
	public void setUp() {
		Book book = new Book("Theory of relativity", "Albert Einstein");
		BookDTO dto=new BookDTO();
		dto.setAuthor("Albert Einstein");
		dto.setTitle("Theory of relativity");
		Mockito.when(bookRepository.findById(1l)).thenReturn(Optional.of(book));
		Mockito.when(bookRatingMapper.asBookDTO(book)).thenReturn(dto);
	}

	@Test
	public void whenValidId_thenBookShouldBeFound() {
		BookDTO dto = bookService.findBookById(1l);
		Assert.assertEquals("Theory of relativity", dto.getTitle());
	}

}
