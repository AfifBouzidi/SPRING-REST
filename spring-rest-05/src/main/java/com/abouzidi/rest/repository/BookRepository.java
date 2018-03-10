package com.abouzidi.rest.repository;

import org.springframework.data.repository.CrudRepository;
import com.abouzidi.rest.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
