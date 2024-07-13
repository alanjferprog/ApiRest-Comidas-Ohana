package com.comidas.ohana.domain.repository;

import com.comidas.ohana.domain.dto.CustomerDto;

import java.util.Optional;

public interface ICustomerDtoRepository
{
    Optional<CustomerDto> getByPhone(String phone);
}
