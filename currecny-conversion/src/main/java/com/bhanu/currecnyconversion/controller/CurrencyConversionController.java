package com.bhanu.currecnyconversion.controller;

import com.bhanu.currecnyconversion.models.CurrencyConversion;
import com.bhanu.currecnyconversion.service.CurrencyConversionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion/v1")
public class CurrencyConversionController {
    Logger logger = LogManager.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/mapping/{from}/{to}/{quantity}")
    public ResponseEntity<CurrencyConversion> getMapping(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("CurrencyConversionController.getMapping from: " + from + ", to: " + to + ", quantity" + quantity);
        return ResponseEntity.ok()
                .body(currencyConversionService.getConversion(from, to, quantity));
    }
}
