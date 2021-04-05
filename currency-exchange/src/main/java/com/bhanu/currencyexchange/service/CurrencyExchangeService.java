package com.bhanu.currencyexchange.service;

import com.bhanu.currencyexchange.models.CurrencyExchange;

public interface CurrencyExchangeService {
    CurrencyExchange getByFromAndTo(final String from, final String to);
}
