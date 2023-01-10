package net.dg.producerservice.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dg.producerservice.model.FoodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class FoodProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(FoodProducer.class);

  @Value("${topic.name}")
  private String orderTopic;

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public FoodProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  public String sendMessage(FoodOrder foodOrder) throws JsonProcessingException {
    String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
    kafkaTemplate.send(orderTopic, orderAsMessage);

    LOGGER.info("Food order produced {}", orderAsMessage);

    return "message sent";
  }
}
