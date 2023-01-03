package com.services.microservicey.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservice-y")
public class Configuration {

	private String email;
	private String domain;
	private String version;

	public Configuration() {
	}

	public Configuration(String email, String domain, String version) {
		super();
		this.email = email;
		this.domain = domain;
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
