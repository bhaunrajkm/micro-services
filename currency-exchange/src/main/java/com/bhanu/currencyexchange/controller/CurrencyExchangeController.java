package com.bhanu.currencyexchange.controller;

import com.bhanu.currencyexchange.models.CurrencyExchange;
import com.bhanu.currencyexchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currency-exchange")
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/mapping/{from}/{to}")
    public ResponseEntity<CurrencyExchange> getMapping(@PathVariable String from, @PathVariable String to) {
        return ResponseEntity.ok()
                .body(currencyExchangeService.getByFromAndTo(from, to));
    }
}
