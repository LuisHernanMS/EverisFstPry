package com.everis.prycliente.models;

import java.util.Date;

public class Student {

	private String id;
	private String name;
	private String flastName;
	private String mlastName;
	private String gender;
	private Date birth;
	private String document;
	private String numberDocument;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlastName() {
		return flastName;
	}
	public void setFlastName(String flastName) {
		this.flastName = flastName;
	}
	public String getMlastName() {
		return mlastName;
	}
	public void setMlastName(String mlastName) {
		this.mlastName = mlastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
	
	
	
}
