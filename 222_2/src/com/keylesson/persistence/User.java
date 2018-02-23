package com.keylesson.persistence;

public class User {

	
	private String name;
	private int age;
	private int id;

	public User() {
	}
	public User(String name,int age,int id) {
		
		this.name = name;
		this.age=age;
		this.id = id;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public User(int id) {
		this.id = id;
		
	}
	public User(String name) {
		
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
