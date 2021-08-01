package com.bhanu.camelms2.routes;

import com.bhanu.camelms2.processers.DivyaQProcesser;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQRoutes extends RouteBuilder {
    @Autowired
    private DivyaQProcesser divyaQProcesser;

    @Override
    public void configure() throws Exception {
//        from("activemq:divya-q")
//                .process(divyaQProcesser);

        from("kafka:myKafkaTopic")
                .process(divyaQProcesser);
    }
}
