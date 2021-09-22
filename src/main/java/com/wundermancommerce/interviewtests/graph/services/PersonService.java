package com.wundermancommerce.interviewtests.graph.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wundermancommerce.interviewtests.graph.model.PersonModel;
import com.wundermancommerce.interviewtests.graph.repository.PersonRepository;
@Service
public class PersonService {
	@Autowired
    PersonRepository personRepository;

    public void save(PersonModel personModel) {
        
    	personRepository.save(personModel);
       
    }
}
