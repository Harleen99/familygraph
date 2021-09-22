package com.wundermancommerce.interviewtests.graph.repository;

import org.springframework.data.repository.CrudRepository;

import com.wundermancommerce.interviewtests.graph.model.RelationShipModel;

public interface RelationshipRepository extends CrudRepository<RelationShipModel,Integer>{

}
