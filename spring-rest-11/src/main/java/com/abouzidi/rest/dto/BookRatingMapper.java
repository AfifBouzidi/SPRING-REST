package com.abouzidi.rest.dto;

import java.util.Collection;

import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.domain.Rating;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL, withCustomFields = { @Field({ "id", "bookDTOId" }) })
public interface BookRatingMapper {

	public BookDTO asBookDTO(Book book);

	public Book asBook(BookDTO bookDto);

	public Collection<BookDTO> asBookCollectionDTO(Collection<Book> books);

	public RatingDTO asRatingDTO(Rating rating);

	public Rating asRating(RatingDTO ratingDto);

	public Collection<RatingDTO> asRatingCollectionDTO(Collection<Rating> rating);

}
