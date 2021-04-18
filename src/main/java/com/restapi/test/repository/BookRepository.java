package com.restapi.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.test.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

	
	public Book findById(int id);
	
}
