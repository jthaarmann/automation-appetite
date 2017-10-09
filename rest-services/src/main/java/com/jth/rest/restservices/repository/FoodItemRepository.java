package com.jth.rest.restservices.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jth.rest.restservices.data.domain.FoodItem;

@RepositoryRestResource
public interface FoodItemRepository extends PagingAndSortingRepository<FoodItem, Long> {

	@Query(value="select fp.item from FoodPortion fp where fp.day.abbreviation = :day")
	Page<FoodItem> findByDay(@Param("day") String day, Pageable page);
}
