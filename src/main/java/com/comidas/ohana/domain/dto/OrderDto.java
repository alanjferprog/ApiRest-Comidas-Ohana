package com.comidas.ohana.domain.dto;

import com.comidas.ohana.persistence.entity.Customer;
import com.comidas.ohana.persistence.entity.OrderItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
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
    private List<OrderItemDto> items;
}
