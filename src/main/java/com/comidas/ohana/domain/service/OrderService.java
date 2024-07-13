package com.comidas.ohana.domain.service;

import com.comidas.ohana.domain.dto.OrderDto;
import com.comidas.ohana.domain.service.dto.RandomOrderDto;
import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import com.comidas.ohana.domain.repository.IOrderDtoRepository;
import com.comidas.ohana.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    private final OrderRepository orderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<List<OrderDto>> getAll()
    { return this.orderRepository.getAll(); }

    public Optional<List<OrderDto>> getByDate(LocalDateTime date)
    { return orderRepository.getByDate(date); }

    public Optional<List<OrderDto>> getTodayOrders()
    {   LocalDateTime today= LocalDate.now().atTime(0,0);
        return this.orderRepository.getTodayOrders(today);
    }

    public Optional<List<OrderDto>> getOutsideOrders()
    {   List<String> methods= Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.getByMethodIn(methods);
    }

    public Optional<List<OrderDto>> getCustomerOrders(String idCostumer)
    { return this.orderRepository.getCustomerOrders(idCostumer); }

    /* public IOrderSummary getSummary(int orderId)
    { return this.orderRepository.findSummary(orderId); }

    @Transactional
    public boolean saveRandomOrder(RandomOrderDto randomOrderDto)
    { return this.orderRepository.saveRandomOrder(randomOrderDto.getIdCustomer(), randomOrderDto.getMethod()); } */
}
