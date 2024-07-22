package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.dto.OrderDto;
import com.comidas.ohana.persistence.entity.Food;
import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.domain.repository.IOrderDtoRepository;
import com.comidas.ohana.persistence.crud.IOrderCrudRepository;
import com.comidas.ohana.persistence.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements IOrderDtoRepository
{
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    @Autowired
    private IOrderMapper orderMapper;

    @Override
    public Optional<List<OrderDto>> getAll()
    {
        List<Order> orders= (List<Order>) orderCrudRepository.findAll();
        return Optional.of(orderMapper.toOrderDtoList(orders));
    }

    public Optional<List<OrderDto>> getTodayOrders(LocalDateTime date)
    {
        Optional<List<Order>> orders= orderCrudRepository.findAllByDateAfter(date);
        return orders.map(order -> orderMapper.toOrderDtoList(order));
    }

    @Override
    public Optional<List<OrderDto>> getByDate(LocalDateTime date)
    {
        Optional<List<Order>> orders= orderCrudRepository.findAllByDate(date);
        return orders.map(order -> orderMapper.toOrderDtoList(order));
    }

    @Override
    public Optional<List<OrderDto>> getByMethodIn(List<String> methods)
    {
        Optional<List<Order>> orders= orderCrudRepository.findAllByMethodIn(methods);
        return orders.map(order -> orderMapper.toOrderDtoList(order));
    }

    @Override
    public Optional<List<OrderDto>> getCustomerOrders(String idCostumer)
    {
        Optional<List<Order>> orders= orderCrudRepository.findCustomerOrders(idCostumer);
        return orders.map(order -> orderMapper.toOrderDtoList(order));
    }

    /* @Override
    public IOrderSummary getSummary(int idOrder) {
        return null;
    }

    @Override
    boolean saveRandomOrder(String idCustomer, String method); */
}
