package com.jth.rest.restservices.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jth.rest.restservices.data.domain.FoodPortion;

@RepositoryRestResource
public interface FoodPortionRepository extends PagingAndSortingRepository<FoodPortion, Long> {
	Page<FoodPortion> findByDayAbbreviation(@Param("day") String day, Pageable page);
	Page<FoodPortion> findByItemGroupName(@Param("group") String group, Pageable page);
	Long countByItemGroupName(@Param("group") String group);
	Page<FoodPortion> findByDayAbbreviationAndItemGroupName(@Param("day") String day, @Param("group") String group, Pageable page);
	Long countByDayAbbreviationAndItemGroupName(@Param("day") String day, @Param("group") String group);
}
