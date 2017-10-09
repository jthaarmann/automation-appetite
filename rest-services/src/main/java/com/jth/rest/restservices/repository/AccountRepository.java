package com.jth.rest.restservices.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jth.rest.restservices.data.domain.Account;

@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

}
