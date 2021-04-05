package com.bhanu.currencyexchange.repository;

import com.bhanu.currencyexchange.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange getByFromAndTo(String from, String to);
}
