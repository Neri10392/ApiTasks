package org.write;

public class Courses {
	
	private String name;
	private String course ;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Courses(String name, String course, String address) {
		super();
		this.name = name;
		this.course = course;
		this.address = address;
	}
	
	
	
	
	
	
}
