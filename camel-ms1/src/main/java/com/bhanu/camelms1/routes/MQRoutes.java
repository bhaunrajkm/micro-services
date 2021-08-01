package com.bhanu.camelms1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MQRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("timer:my-timer?period=10000")
//                .transform().constant("My name is divya")
//                .to("activemq:divya-q");

        from("timer:my-timer?period=5000")
                .transform().constant("My name is divya")
                .to("kafka:myKafkaTopic")
                .log("Message published: ${body}");


//        restConfiguration().host("localhost").port("8081");
//        from("timer:my-timer?period=10000")
//                .to("rest:get:/ms2/conversion/USD/INR")
//                .log("${body}");
    }
}
