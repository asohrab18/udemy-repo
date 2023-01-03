package com.services.microservicex.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice-x")
public class Configuration {

	private String name;
	private String language;
	private String technology;

	public Configuration() {
	}

	public Configuration(String name, String language, String technology) {
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
