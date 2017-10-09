package com.jth.rest.restservices.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jth.rest.restservices.data.domain.Exercise;

@RepositoryRestResource
public interface ExerciseRepositoy extends PagingAndSortingRepository<Exercise, Long> {

	@Query(value="select es.exercise from ExerciseSession es where es.day.abbreviation = :day")
	Page<Exercise> findByDay(@Param("day") String day, Pageable page);
}
