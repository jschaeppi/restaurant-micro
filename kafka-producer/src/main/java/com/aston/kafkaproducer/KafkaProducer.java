package com.aston.kafkaproducer;

import com.aston.kafkaproducer.ack.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/kafka/")
public class KafkaProducer {

    Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Ingredient> kafkaTemplate;

    private final static String TOPIC = "orders";

    @PostMapping("/ingredient/add")
        public String addIngredient(@RequestBody List<Ingredient> ingredientList) {
        for (Ingredient ingredient : ingredientList) {
            kafkaTemplate.send(TOPIC, ingredient);
        }

        return "Published Successfully";
    }
}
