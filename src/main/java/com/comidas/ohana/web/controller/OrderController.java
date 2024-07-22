package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.dto.OrderDto;
import com.comidas.ohana.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll()
    {  return this.orderService.getAll().filter(Predicate.not(List::isEmpty))
            .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderDto>> getTodayOrders()
    {
        return this.orderService.getTodayOrders().filter(Predicate.not(List::isEmpty))
            .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<OrderDto>> getCustomerOrders(@PathVariable LocalDateTime date)
    { return this.orderService.getByDate(date).filter(Predicate.not(List::isEmpty))
            .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/outside")
    public ResponseEntity<List<OrderDto>> getOutsideOrders()
    { return this.orderService.getOutsideOrders().filter(Predicate.not(List::isEmpty))
            .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderDto>> getCustomerOrders(@PathVariable String id)
    { return this.orderService.getCustomerOrders(id).filter(Predicate.not(List::isEmpty))
            .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* @GetMapping("/summary/{idorder}")
    public ResponseEntity<IOrderSummary> getSummary(@PathVariable int idorden)
    { return ResponseEntity.ok(this.orderService.getSummary(idorden)); }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto)
    { return ResponseEntity.ok(this.orderService.saveRandomOrder(dto)); } */
}
