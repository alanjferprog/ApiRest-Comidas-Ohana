package com.comidas.ohana.domain.service.dto;

import lombok.Data;

@Data
public class UpdateFoodPriceDto
{
    private int foodId;
    private double newPrice;
}
