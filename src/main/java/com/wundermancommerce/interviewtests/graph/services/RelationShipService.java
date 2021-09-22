package com.wundermancommerce.interviewtests.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wundermancommerce.interviewtests.graph.model.RelationShipModel;
import com.wundermancommerce.interviewtests.graph.repository.RelationshipRepository;

@Service
public class RelationShipService {
	@Autowired
    RelationshipRepository relationShipRepository;

    public void save(RelationShipModel relationShipModel) {
        
    	relationShipRepository.save(relationShipModel);
       
    }
}
