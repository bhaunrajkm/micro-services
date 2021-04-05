package com.bhanu.currecnyconversion.restClient;

import com.bhanu.currecnyconversion.models.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeFeignClient {
    @GetMapping("/currency-exchange/v1/mapping/{from}/{to}")
    ResponseEntity<CurrencyConversion> getMapping(@PathVariable String from, @PathVariable String to);
}
