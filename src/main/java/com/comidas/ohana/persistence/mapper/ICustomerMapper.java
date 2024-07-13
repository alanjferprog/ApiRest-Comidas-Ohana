package com.comidas.ohana.persistence.mapper;

import com.comidas.ohana.domain.dto.CustomerDto;
import com.comidas.ohana.persistence.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerMapper
{
    CustomerDto toCustomerDto(Customer customer);
}
