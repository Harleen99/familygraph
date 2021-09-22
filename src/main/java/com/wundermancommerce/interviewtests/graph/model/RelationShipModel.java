package com.wundermancommerce.interviewtests.graph.model;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Relationship")
public class RelationShipModel {
	@Id
   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
    @JoinColumn(name="email", nullable=false)
	private PersonModel person;
	@Basic
    @Column(name = "familyemailId",  length = 256)
	private String familyEmailId;
	@Basic
    @Column(name = "friendemailId",  length = 256)
	private String friendEmailId;
	public PersonModel getPerson() {
		return person;
	}
	public void setPerson(PersonModel person) {
		this.person = person;
	}
	public String getFamilyEmailId() {
		return familyEmailId;
	}
	public void setFamilyEmailId(String familyEmailId) {
		this.familyEmailId = familyEmailId;
	}
	public String getFriendEmailId() {
		return friendEmailId;
	}
	public void setFriendEmailId(String friendEmailId) {
		this.friendEmailId = friendEmailId;
	}
}
