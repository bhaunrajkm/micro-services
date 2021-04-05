package com.bhanu.currecnyconversion.service;

import com.bhanu.currecnyconversion.models.CurrencyConversion;
import com.bhanu.currecnyconversion.restClient.CurrencyExchangeFeignClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    Logger logger = LogManager.getLogger(CurrencyConversionServiceImpl.class);

    @Autowired
    private CurrencyExchangeFeignClient currencyExchangeFeignClient;

    @Override
    public CurrencyConversion getConversion(final String from,
                                            final String to,
                                            final BigDecimal quantity) {
        logger.info("CurrencyConversionServiceImpl.getConversion from: " + from + ", to: " + to + ", quantity" + quantity);
        CurrencyConversion currencyConversion = currencyExchangeFeignClient.getMapping(from, to).getBody();
        currencyConversion.setTotal(currencyConversion.getRate().multiply(quantity));
        currencyConversion.setQuantity(quantity);
        logger.info("CurrencyConversionServiceImpl.getConversion response:", currencyConversion);
        return currencyConversion;
    }
}
