package com.aston.kafkaproducer.producers;

import com.aston.kafkaproducer.model.ack.Ingredient;
import com.aston.kafkaproducer.model.ack.IngredientType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/kafka")
public class KafkaIngredientType {

        Logger log = LoggerFactory.getLogger(KafkaIngredient.class);

        @Autowired
        private KafkaTemplate<String, Object> kafkaTemplate;


        private final static String TOPIC = "ingredientType";

        @PostMapping("/ingredienttype/add")
        public void addIngredient(@RequestBody List<IngredientType> ingredientTypeList) {
                for (IngredientType ingredientType : ingredientTypeList) {
                        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(TOPIC, ingredientType);
                        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                                @Override
                                public void onFailure(Throwable throwable) {
                                        log.warn("Ingredient Type failed due to: " + throwable);
                                }

                                @Override
                                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                                        log.info("Ingredient Type sent successfully");
                                }
                        });
                }

        }

}
