package com.bhanu.currecnyconversion.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyConversion {
    private long id;
    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal quantity;
    private BigDecimal total;
}
