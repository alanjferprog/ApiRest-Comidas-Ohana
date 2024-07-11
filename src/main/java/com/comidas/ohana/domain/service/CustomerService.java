package com.comidas.ohana.domain.service;

import com.comidas.ohana.persistence.entity.Customer;
import com.comidas.ohana.persistence.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByPhone(String phone)
    { return this.customerRepository.findByPhone(phone); }
}
