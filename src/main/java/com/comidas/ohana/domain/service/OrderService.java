package com.comidas.ohana.domain.service;

import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import com.comidas.ohana.persistence.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService
{
    private final IOrderRepository orderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll()
    { return this.orderRepository.findAll(); }

    public List<Order> getTodayOrders()
    {   LocalDateTime today= LocalDate.now().atTime(0,0);
        return this.orderRepository.findAllByDateAfter(today);
    }

    public List<Order> getOutsideOrders()
    {   List<String> methods= Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }

    public List<Order> getCustomerOrders(String idCostumer)
    { return this.orderRepository.findCustomerOrders(idCostumer); }

    public IOrderSummary getSummary(int orderId)
    { return this.orderRepository.findSummary(orderId); }
}
