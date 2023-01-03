package com.services.microservicex.bean;

public class AppData {

	private String name;
	private String language;
	private String technology;

	public AppData() {
	}

	public AppData(String name, String language, String technology) {
		super();
		this.name = name;
		this.language = language;
		this.technology = technology;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

}
