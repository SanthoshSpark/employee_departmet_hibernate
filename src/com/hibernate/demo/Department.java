package com.hibernate.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(long id, String name, String location, Set<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	public Department(String name, String location, Set<Employee> employees) {
		super();
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", employees=" + employees
				+ "]";
	}
	
	

}
