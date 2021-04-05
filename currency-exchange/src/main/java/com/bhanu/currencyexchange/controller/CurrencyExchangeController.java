package com.bhanu.currencyexchange.controller;

import com.bhanu.currencyexchange.models.CurrencyExchange;
import com.bhanu.currencyexchange.service.CurrencyExchangeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange/v1")
public class CurrencyExchangeController {

    Logger logger = LogManager.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/mapping/{from}/{to}")
    public ResponseEntity<CurrencyExchange> getMapping(@PathVariable String from, @PathVariable String to) {
        logger.info("CurrencyExchangeController.getMapping from: " + from + ", to: " + to);
        return ResponseEntity.ok()
                .body(currencyExchangeService.getByFromAndTo(from, to));
    }
}
