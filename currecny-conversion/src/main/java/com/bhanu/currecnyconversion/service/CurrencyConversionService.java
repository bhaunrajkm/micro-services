package com.bhanu.currecnyconversion.service;

import com.bhanu.currecnyconversion.models.CurrencyConversion;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    CurrencyConversion getConversion(final String from, final String to, final BigDecimal quantity);
}
