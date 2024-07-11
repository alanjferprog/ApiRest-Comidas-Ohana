package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.OrderService;
import com.comidas.ohana.domain.service.dto.RandomOrderDto;
import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<Order>> getAll()
    { return ResponseEntity.ok(this.orderService.getAll()); }

    @GetMapping("/today")
    public ResponseEntity<List<Order>> getTodayOrders()
    { return ResponseEntity.ok(this.orderService.getTodayOrders()); }

    @GetMapping("/outside")
    public ResponseEntity<List<Order>> getOutsideOrders()
    { return ResponseEntity.ok(this.orderService.getOutsideOrders()); }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable String id)
    { return ResponseEntity.ok(this.orderService.getCustomerOrders(id)); }

    @GetMapping("/summary/{idorder}")
    public ResponseEntity<IOrderSummary> getSummary(@PathVariable int idorden)
    { return ResponseEntity.ok(this.orderService.getSummary(idorden)); }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto)
    { return ResponseEntity.ok(this.orderService.saveRandomOrder(dto)); }
}
