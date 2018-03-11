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
import com.abouzidi.rest.domain.Rating;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RatingRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RatingRepository ratingRepository;

	@Test
	public void whenFindById_thenReturnRating() {
		
		Book book = new Book("Theory of relativity", "Albert Einstein");
		Rating rating =new Rating(5);
		book.getRatings().add(rating);
		rating.setBook(book);
		entityManager.persist(book);
		entityManager.flush();

		Optional<Rating> found = ratingRepository.findById(rating.getId());
		Assert.assertTrue(found.isPresent());
		
	}
	

}
