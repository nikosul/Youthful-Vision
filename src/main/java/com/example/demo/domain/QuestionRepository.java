package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
		List<Question> findByTitle(String title);
		Optional<Question> findById(Long id);
}