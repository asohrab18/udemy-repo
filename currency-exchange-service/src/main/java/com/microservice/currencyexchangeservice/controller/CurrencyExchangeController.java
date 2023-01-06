package com.microservice.currencyexchangeservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.microservice.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable("from") String from, @PathVariable("to") String to) {
		logger.info("getCurrencyExchange called with {} to {}", from, to);
		Optional<CurrencyExchange> opt = repository.findByFromAndTo(from, to);
		if (!opt.isPresent()) {
			throw new RuntimeException("no data available from " + from + " to " + to);
		}
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = opt.get();
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
