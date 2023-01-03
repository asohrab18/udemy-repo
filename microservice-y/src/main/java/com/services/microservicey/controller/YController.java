package com.services.microservicey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.microservicey.configuration.Configuration;

@RestController
@RequestMapping("y-service")
public class YController {

	@Autowired
	private Configuration config;

	@GetMapping("/details")
	public String getDetails() {
		return "Email Id: " + config.getEmail() + "<br/>Domain: " + config.getDomain() + "<br/>Version: "
				+ config.getVersion();
	}
}
