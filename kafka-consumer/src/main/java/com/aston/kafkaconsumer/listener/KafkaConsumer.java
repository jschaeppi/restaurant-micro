package com.aston.kafkaconsumer.listener;

import com.aston.kafkaconsumer.model.ack.CustomerOrder;
import com.aston.kafkaconsumer.model.ack.Ingredient;
import com.aston.kafkaconsumer.model.ack.IngredientType;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "orders", groupId = "rest_group", properties = {"spring.json.value.default.type=com.aston.kafkaconsumer.model.ack.CustomerOrder", "spring.json.use.type.headers=false"})
    public void consumeOrders(CustomerOrder customerOrder) {
        log.info(customerOrder.getId().toString());
        log.info(customerOrder.getVersion().toString());
    }

    @KafkaListener(topics = "ingredient", groupId = "rest_group", properties = {"spring.json.value.default.type=com.aston.kafkaconsumer.model.ack.Ingredient", "spring.json.use.type.headers=false"})
    public void consumeIngredients(Ingredient ingredient) {
        log.info(KafkaHeaders.RECEIVED);

    }

    @KafkaListener(topics = "ingredientType", groupId = "rest_group", properties = {"spring.json.value.default.type=com.aston.kafkaconsumer.model.ack.IngredientType", "spring.json.use.type.headers=false"})
    public void consumeIngredientTypes(IngredientType ingredientType) {
        if (ingredientType == null) {
            log.warn("No data was sent");
        }
//        log.info(KafkaHeaders.RECEIVED);
        log.info(ingredientType.toString());
        log.info(ingredientType.getType());
    }
}
