package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.dto.CustomerDto;
import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.service.CustomerService;
import com.comidas.ohana.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/customers")
public class CustomerController
{
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAll()
    { return this.customerService.getAll().filter(Predicate.not(List::isEmpty))
            .map(customers -> new ResponseEntity<>(customers, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerDto> get(@PathVariable String idCustomer)
    { return ResponseEntity.ok(this.customerService.get(idCustomer));}

    @GetMapping("/byphone/{phone}")
    public ResponseEntity<CustomerDto> getByPhone(@PathVariable("phone") String phone)
    { return customerService.findByPhone(phone)
            .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
