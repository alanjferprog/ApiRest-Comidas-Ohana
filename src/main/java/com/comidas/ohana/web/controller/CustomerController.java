package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.CustomerService;
import com.comidas.ohana.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController
{
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/byphone/{phone}")
    public ResponseEntity<Customer> getByPhone(@PathVariable("phone") String phone)
    { return ResponseEntity.ok(this.customerService.findByPhone(phone)); }
}
