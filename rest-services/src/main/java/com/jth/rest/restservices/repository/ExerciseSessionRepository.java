package com.jth.rest.restservices.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jth.rest.restservices.data.domain.ExerciseSession;

@RepositoryRestResource
public interface ExerciseSessionRepository extends PagingAndSortingRepository<ExerciseSession, Long> {

	Page<ExerciseSession> findByExerciseExerciseTypeType(@Param("type") String type, Pageable page);
	Long countByExerciseExerciseTypeType(@Param("type") String type);
	Page<ExerciseSession> findByDayAbbreviation(@Param("day") String day, Pageable page);
	Long countByDayAbbreviation(@Param("day") String day);
	
}
