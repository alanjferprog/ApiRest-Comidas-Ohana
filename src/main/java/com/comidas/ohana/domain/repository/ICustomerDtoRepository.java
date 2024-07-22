package com.comidas.ohana.domain.repository;

import com.comidas.ohana.domain.dto.CustomerDto;
import com.comidas.ohana.domain.dto.FoodDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerDtoRepository
{
    Optional<List<CustomerDto>> getAll();
    Optional<CustomerDto> get(String customerId);
    Optional<CustomerDto> getByPhone(String phone);
}
