package com.microservice.configclientapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.configclientapp.configuration.Configuration;

@RestController
@RequestMapping("config-client")
public class ConfigController {

	@Autowired
	private Configuration config;

	@GetMapping("/db-details")
	public String getDatabaseDetails() {
		return "Database URL: " + config.getDbUrl() + "<br/>Username: " + config.getUsername() + "<br/>Password: "
				+ config.getPassword();
	}

}
