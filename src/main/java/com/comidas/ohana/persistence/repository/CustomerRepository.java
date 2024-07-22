package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.domain.dto.CustomerDto;
import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.repository.ICustomerDtoRepository;
import com.comidas.ohana.persistence.crud.ICustomerCrudRepository;
import com.comidas.ohana.persistence.entity.Customer;
import com.comidas.ohana.persistence.entity.Food;
import com.comidas.ohana.persistence.mapper.ICustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements ICustomerDtoRepository
{
    @Autowired
    private ICustomerCrudRepository customerCrudRepository;
    @Autowired
    private ICustomerMapper customerMapper;

    @Override
    public Optional<List<CustomerDto>> getAll()
    {
        List<Customer> customers= (List<Customer>) customerCrudRepository.findAll();
        return Optional.of(customerMapper.toCustomersDto(customers));
    }

    @Override
    public Optional<CustomerDto> get(String customerId) {
        Optional<Customer> customer= customerCrudRepository.findById(customerId);
        return customer.map(c -> customerMapper.toCustomerDto(c));
    }

    @Override
    public Optional<CustomerDto> getByPhone(String phone)
    {
        Optional<Customer> customer= customerCrudRepository.findByPhone(phone);
        return customer.map(c -> customerMapper.toCustomerDto(c));
    }
}
