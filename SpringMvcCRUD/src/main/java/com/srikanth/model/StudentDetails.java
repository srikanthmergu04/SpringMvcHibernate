package com.srikanth.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table
@DynamicUpdate
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String sName;
	
	@Column
	private Integer age;
	
	@Column
	private String gender;
	
	@Column
	private String dept;
	

	
	@ManyToMany(cascade = CascadeType.ALL , targetEntity = StudentDetails.class)
	private List<StudentDetails> beneficiary;
	
	

	
	public List<StudentDetails> getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(List<StudentDetails> beneficiary) {
	this.beneficiary = beneficiary;
	}
	
	
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
 
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
