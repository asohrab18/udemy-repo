package com.microservice.configclientapp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my-config")
public class Configuration {

	private String dbUrl;
	private String username;
	private String password;

	public Configuration() {
	}

	public Configuration(String dbUrl, String username, String password) {
		super();
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
