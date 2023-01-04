package com.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.CurrencyExchangeProxy;
import com.microservices.currencyconversionservice.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> uriParameters = new HashMap<String, String>();
		uriParameters.put("from", from);
		uriParameters.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriParameters);
		CurrencyConversion ccObj = responseEntity.getBody();
		return new CurrencyConversion(ccObj.getId(), from, to, quantity, ccObj.getConversionMultiple(),
				quantity.multiply(ccObj.getConversionMultiple()), ccObj.getEnvironment()+" by RestTemplate.");
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversionFeign(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversion ccObj = proxy.getCurrencyExchangeValue(from, to);
		return new CurrencyConversion(ccObj.getId(), from, to, quantity, ccObj.getConversionMultiple(),
				quantity.multiply(ccObj.getConversionMultiple()), ccObj.getEnvironment()+" by feign.");
	}
}
