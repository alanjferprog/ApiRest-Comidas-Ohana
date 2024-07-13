package com.comidas.ohana.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto
{
    private Integer foodId;
    private String name;
    private Double price;
    private Boolean available;
}
