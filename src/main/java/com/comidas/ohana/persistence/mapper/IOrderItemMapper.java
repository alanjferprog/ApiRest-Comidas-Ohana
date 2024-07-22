package com.comidas.ohana.persistence.mapper;

import com.comidas.ohana.domain.dto.OrderItemDto;
import com.comidas.ohana.persistence.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderItemMapper
{
    OrderItemDto toOrderItemDto(OrderItem orderItem);
    List<OrderItemDto> toOrdersItemDto(List<OrderItem> orderItemList);
}
