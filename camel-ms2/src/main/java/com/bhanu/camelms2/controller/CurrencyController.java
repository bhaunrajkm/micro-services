package com.bhanu.camelms2.controller;

import com.bhanu.camelms2.models.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/ms2")
public class CurrencyController {
    @GetMapping("/conversion/{from}/{to}")
    public ResponseEntity<?> getConversion(@PathVariable("from") String from,
                                           @PathVariable("to") String to) {
        return ResponseEntity.ok(new Currency(from, to, BigDecimal.TEN));
    }
}
