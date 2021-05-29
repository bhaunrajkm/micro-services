package com.bhanu.camelms1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MQRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:my-timer?period=10000")
                .transform().constant("My name is divya")
                .to("activemq:divya-q");
    }
}
