package com.abouzidi.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.abouzidi.rest.dto.BookRatingMapper;

import fr.xebia.extras.selma.Selma;

@Configuration
public class BookRatingConfiguration {

	@Bean
	BookRatingMapper bookRatingMapper() {
		return Selma.builder(BookRatingMapper.class).build();
	}

}
