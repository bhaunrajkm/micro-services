package com.bhanu.currencyexchange.service;

import com.bhanu.currencyexchange.models.CurrencyExchange;
import com.bhanu.currencyexchange.repository.CurrencyExchangeRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    Logger logger = LogManager.getLogger(CurrencyExchangeServiceImpl.class);

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @Override
    public CurrencyExchange getByFromAndTo(String from, String to) {
        logger.info("CurrencyExchangeServiceImpl.getByFromAndTo from: " + from + ", to: " + to);
        com.bhanu.currencyexchange.entities.CurrencyExchange currency = currencyExchangeRepo.getByFromAndTo(from, to);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        BeanUtils.copyProperties(currency, currencyExchange);
        logger.info("CurrencyExchangeServiceImpl.getByFromAndTo response: ", currencyExchange);
        return currencyExchange;
    }
}

