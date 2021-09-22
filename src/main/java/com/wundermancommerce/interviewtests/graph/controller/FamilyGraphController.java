package com.wundermancommerce.interviewtests.graph.controller;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.wundermancommerce.interviewtests.graph.model.PersonModel;
import com.wundermancommerce.interviewtests.graph.model.RelationShipModel;
import com.wundermancommerce.interviewtests.graph.services.PersonService;
import com.wundermancommerce.interviewtests.graph.services.RelationShipService;

@RestController
@RequestMapping("/PR")
public class FamilyGraphController {
	 @Autowired
	    PersonService personService;
	 @Autowired
	    RelationShipService relationShipService;
    @PostMapping("/createData")
   public  String createDataFromExcel(){
      
    	
    	String fileNamePeople = "C:\\Users\\Harleen Kaur\\Downloads\\familygraph\\src\\test\\resources\\people.csv";
    	String fileNameRelationShips = "C:\\Users\\Harleen Kaur\\Downloads\\familygraph\\src\\test\\resources\\relationships.csv";
    	PersonModel personModel=new PersonModel();
    	Set<RelationShipModel> familyRelationShips=new HashSet<RelationShipModel>();
        try (CSVReader reader = new CSVReader(new FileReader(fileNamePeople))) {
            List<String[]> r = reader.readAll();
           // r.forEach(x -> System.out.println("Data is"+Arrays.toString(x)));
            r.forEach(x -> {
            	
            System.out.println("Data at cell 1 is"  +x[0]+"Data at cell 2 is"+x[1]+"Data at cell 3 is"+x[2]);
            personModel.setPersonName(x[0]);
            personModel.setPersonEmail(x[1]);
            personModel.setPersonAge(Integer.valueOf(x[2]));
            personService.save(personModel);
            try (CSVReader readerRelationShip = new CSVReader(new FileReader(fileNameRelationShips))) {
            	 List<String[]> row = readerRelationShip.readAll();
            	 row.forEach(cell->{
            		 if(cell[0].equalsIgnoreCase(x[1])) {
            			 RelationShipModel relationshipModel=new RelationShipModel();
            			 System.out.println("Rel ship data"  +cell[0]+"****"+cell[1]+"*******"+cell[2]);
            			if(cell[1].equalsIgnoreCase("FAMILY")) {
            				relationshipModel.setFamilyEmailId(cell[2]);
            				relationshipModel.setFriendEmailId(null);
            				relationshipModel.setPerson(personModel);
            			}else {
            				relationshipModel.setFamilyEmailId(null);
            				relationshipModel.setFriendEmailId(cell[2]);
            				relationshipModel.setPerson(personModel);
            			}
            			// add for saving relationships//
            			relationShipService.save(relationshipModel);
            			//familyRelationShips.add(relationshipModel);
            		 }
            	 });
            }catch(Exception e) {
            	System.out.println("Exception For Reading Relationship file"+e.getMessage());
            }
      //      personModel.setFamilyRelationShips(familyRelationShips);
         
            
            }
            );
            
        }catch(Exception e) {
        	System.out.println("Exception"+e.getMessage());
        }
        return "Data created";
    }
}
