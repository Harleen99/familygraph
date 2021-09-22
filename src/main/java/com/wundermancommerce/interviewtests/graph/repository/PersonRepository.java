package com.wundermancommerce.interviewtests.graph.repository;

import org.springframework.data.repository.CrudRepository;

import com.wundermancommerce.interviewtests.graph.model.PersonModel;

public interface PersonRepository extends CrudRepository<PersonModel,String>{ 

}