package com.comidas.ohana.domain.dto;

import com.comidas.ohana.persistence.entity.Customer;
import com.comidas.ohana.persistence.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto
{
    private int orderId;
    private String customerId;
    private LocalDateTime date;
    private Double total;
    private String method;
    private String additional_notes;
    private Customer customer;
    private List<OrderItem> items;
}
