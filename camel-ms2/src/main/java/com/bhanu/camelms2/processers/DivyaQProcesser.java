package com.bhanu.camelms2.processers;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DivyaQProcesser implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info(exchange.getMessage().getBody(String.class));
    }
}
