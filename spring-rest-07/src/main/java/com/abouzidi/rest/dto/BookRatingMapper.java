package com.abouzidi.rest.dto;

import java.util.Collection;
import com.abouzidi.rest.domain.Book;
import com.abouzidi.rest.domain.Rating;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper
public interface BookRatingMapper {

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	public BookDTO asBookDTO(Book book);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	public Book asBook(BookDTO bookDto);
	
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	public Collection<BookDTO> asBookCollectionDTO(Collection<Book> books);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	public RatingDTO asRatingDTO(Rating rating);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	public Rating asRating(RatingDTO ratingDto);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	public Collection<RatingDTO> asRatingCollectionDTO(Collection<Rating> rating);

}
