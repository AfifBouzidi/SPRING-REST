package com.abouzidi.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.abouzidi.rest.domain.Rating;

public interface RatingRepository extends PagingAndSortingRepository<Rating, Long> {

}
