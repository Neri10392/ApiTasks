package org.write;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String name;
	private String email;
	private long phone;
	List<Courses> courses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public Employee(String name, String email, long phone, List<Courses> courses) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.courses = courses;
	}

}
