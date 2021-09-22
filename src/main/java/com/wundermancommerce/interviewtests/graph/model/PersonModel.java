package com.wundermancommerce.interviewtests.graph.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "PersonDetails")
public class PersonModel {
	 
	    private String personName;
	    private String personEmail;
	    private int personAge;
	    @Basic
	    @Column(name = "name", nullable = false, length = 256)
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		@Id
	    @Column(name = "email", nullable = false, length = 256)
		public String getPersonEmail() {
			return personEmail;
		}
		public void setPersonEmail(String personEmail) {
			this.personEmail = personEmail;
		}
		@Basic
	    @Column(name = "age", nullable = false)
		public int getPersonAge() {
			return personAge;
		}
		public void setPersonAge(int personAge) {
			this.personAge = personAge;
		}
		@ElementCollection(targetClass=RelationShipModel.class)
	    private Set<RelationShipModel> familyRelationShips=new HashSet<RelationShipModel>();
	    @OneToMany(mappedBy="person",cascade=CascadeType.ALL)
		public Set<RelationShipModel> getFamilyRelationShips() {
			return familyRelationShips;
		}
		public void setFamilyRelationShips(Set<RelationShipModel> familyRelationShips) {
			this.familyRelationShips = familyRelationShips;
		}
}
