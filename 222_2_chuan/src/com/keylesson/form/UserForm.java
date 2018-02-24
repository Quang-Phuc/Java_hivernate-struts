package com.keylesson.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int age;
	private String dispatch;
	
	
	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public void reset() {
		this.name = null;
		
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