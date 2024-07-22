package com.comidas.ohana.domain.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto
{
    private int orderId;
    private int itemId;
    private int foodId;
    private Double quantity;
    private Double price;
    private FoodDto food;
}
