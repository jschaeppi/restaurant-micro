package com.aston.kafkaconsumer.listener;

import com.aston.kafkaconsumer.model.ack.CustomerOrder;
import com.aston.kafkaconsumer.model.ack.Ingredient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "orders",errorHandler = "")
    public void consumeOrders(CustomerOrder customerOrder) {
        customerOrder.getMenuItems().iterator().forEachRemaining(menuItem -> log.info(menuItem.getName()));
        log.info(customerOrder.getMenuItems().get(0).getName());
    }

    @KafkaListener(topics = "ingredients", groupId = "ingredient_group")
    public void consumeIngredients(Ingredient ingredient) {
        log.info(KafkaHeaders.RECEIVED);
        ingredient.getIngredientType();
//        log.info(ingredient.getIngredientType().toString());
    }
}
