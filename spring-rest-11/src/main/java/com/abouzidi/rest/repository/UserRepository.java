package com.abouzidi.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.abouzidi.rest.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}
