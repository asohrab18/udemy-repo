package com.microservice.currencyexchangeservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public Optional<CurrencyExchange> findByFromAndTo(String from, String to);

}
