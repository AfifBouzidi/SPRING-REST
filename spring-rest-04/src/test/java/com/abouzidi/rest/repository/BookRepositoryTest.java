package com.abouzidi.rest.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.abouzidi.rest.domain.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void whenFindById_thenReturnBook() {

		Book book = new Book("Theory of relativity", "Albert Einstein");
		entityManager.persist(book);
		entityManager.flush();

		Optional<Book> found = bookRepository.findById(book.getId());
		Assert.assertTrue(found.isPresent());

	}

}
