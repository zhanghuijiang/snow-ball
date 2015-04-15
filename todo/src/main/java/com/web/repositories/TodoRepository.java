package com.web.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.web.model.mongodb.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
	@Query("{title:{$regex:?0, $options: 'i' } }")
	public List<Todo> findByTitle(String title);	
}
