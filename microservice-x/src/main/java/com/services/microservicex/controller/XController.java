package com.services.microservicex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.microservicex.bean.AppData;
import com.services.microservicex.configuration.Configuration;

@RestController
@RequestMapping("x-service")
public class XController {

	@Autowired
	private Configuration config;

	@GetMapping("/app-details")
	public AppData getDetails() {
		return new AppData(config.getName(), config.getLanguage(), config.getTechnology());
	}

}
