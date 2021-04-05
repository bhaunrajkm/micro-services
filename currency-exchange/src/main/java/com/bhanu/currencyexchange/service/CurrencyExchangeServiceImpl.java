package com.bhanu.currencyexchange.service;

import com.bhanu.currencyexchange.models.CurrencyExchange;
import com.bhanu.currencyexchange.repository.CurrencyExchangeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @Override
    public CurrencyExchange getByFromAndTo(String from, String to) {
        com.bhanu.currencyexchange.entities.CurrencyExchange currency = currencyExchangeRepo.getByFromAndTo(from, to);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        BeanUtils.copyProperties(currency, currencyExchange);
        return currencyExchange;
    }
}

