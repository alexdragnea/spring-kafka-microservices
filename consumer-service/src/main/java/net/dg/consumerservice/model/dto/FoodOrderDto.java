package net.dg.consumerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@Value
@AllArgsConstructor
public class FoodOrderDto {

    private String item;
    private Double amount;
}
