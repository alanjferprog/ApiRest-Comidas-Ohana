package com.comidas.ohana.domain.service;

import com.comidas.ohana.domain.dto.CustomerDto;
import com.comidas.ohana.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService
{
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerDto> findByPhone(String phone)
    { return this.customerRepository.getByPhone(phone); }
}
