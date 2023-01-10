package net.dg.consumerservice.service;

import net.dg.consumerservice.model.FoodOrder;
import net.dg.consumerservice.model.dto.FoodOrderDto;
import net.dg.consumerservice.repository.FoodOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class FoodOrderService {

  private static final Logger LOGGER = LoggerFactory.getLogger(FoodOrderService.class);

  private final FoodOrderRepository foodOrderRepository;
  private final ModelMapper modelMapper;

  public void persistFoodOrder(FoodOrderDto foodOrderDto) {
    FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
    FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);

    LOGGER.info("Food order persisted {}", persistedFoodOrder);
  }
}
