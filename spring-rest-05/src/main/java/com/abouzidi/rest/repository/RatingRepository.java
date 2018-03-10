package com.abouzidi.rest.repository;

import org.springframework.data.repository.CrudRepository;
import com.abouzidi.rest.domain.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
