package com.bhanu.currencyexchange.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyExchange {
    private long id;
    private String from;
    private String to;
    private BigDecimal rate;
}
