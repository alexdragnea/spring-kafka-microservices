package net.dg.producerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import net.dg.producerservice.model.FoodOrder;
import net.dg.producerservice.service.producer.FoodProducer;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodOrderService {

    private final FoodProducer producer;

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
        return producer.sendMessage(foodOrder);
    }
}
