package com.rajan.hibernate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ABC")
public class Employee {
	
	private int id;
	private int name;
	private String lastName;
	
	@Id
	@Generated(value = { "native" })
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="STATUS")
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	 @Column(insertable=false, updatable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
