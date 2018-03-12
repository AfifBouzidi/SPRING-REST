package com.abouzidi.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.abouzidi.rest.domain.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
