package net.dg.producerservice.model;

import lombok.*;

@Data
@AllArgsConstructor
public class FoodOrder {

    private String item;
    private Double amount;
}
