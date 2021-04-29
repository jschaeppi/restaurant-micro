package com.aston.kafkaproducer.producers;

import com.aston.kafkaproducer.model.ack.CustomerOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/kafka")
public class KafkaCustomerOrder {

    Logger log = LoggerFactory.getLogger(KafkaCustomerOrder.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final static String TOPIC = "orders";

    @PostMapping("/order/add")
        public String addCustomerOrder(@RequestBody List<CustomerOrder> customerOrderList) {
        for (CustomerOrder customerOrder : customerOrderList) {
            kafkaTemplate.send(TOPIC, customerOrder);
        }

        return "Published Successfully";
    }
}
