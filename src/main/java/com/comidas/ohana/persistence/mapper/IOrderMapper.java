package com.comidas.ohana.persistence.mapper;

import com.comidas.ohana.domain.dto.OrderDto;
import com.comidas.ohana.persistence.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderMapper
{
    OrderDto toOrderDto(Order order);
    List<OrderDto> toOrderDtoList(List<Order> orderList);
}
