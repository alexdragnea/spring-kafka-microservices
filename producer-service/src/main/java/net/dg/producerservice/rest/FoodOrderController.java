package net.dg.producerservice.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import net.dg.producerservice.model.FoodOrder;
import net.dg.producerservice.service.FoodOrderService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class FoodOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodOrderController.class);

    private final FoodOrderService foodOrderService;

    @PostMapping
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        LOGGER.info("Food order request received.");
        return foodOrderService.createFoodOrder(foodOrder);
    }
}
