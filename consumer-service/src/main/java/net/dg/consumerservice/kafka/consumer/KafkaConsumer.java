package net.dg.consumerservice.kafka.consumer;

import net.dg.consumerservice.model.dto.FoodOrderDto;
import net.dg.consumerservice.service.FoodOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  private static final String orderTopic = "${topic.name}";

  private final ObjectMapper objectMapper;
  private final FoodOrderService foodOrderService;

  public KafkaConsumer(ObjectMapper objectMapper, FoodOrderService foodOrderService) {
    this.objectMapper = objectMapper;
    this.foodOrderService = foodOrderService;
  }

  @KafkaListener(topics = orderTopic)
  public void consumeMessage(String message) throws JsonProcessingException {
    LOGGER.info("Message consumed {}", message);

    FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
    foodOrderService.persistFoodOrder(foodOrderDto);
  }
}
