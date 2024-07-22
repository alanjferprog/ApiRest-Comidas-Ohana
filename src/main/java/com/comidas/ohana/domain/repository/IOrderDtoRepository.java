package com.comidas.ohana.domain.repository;

import com.comidas.ohana.domain.dto.OrderDto;
import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderDtoRepository
{
    Optional<List<OrderDto>> getAll();
    Optional<List<OrderDto>> getTodayOrders(LocalDateTime date);
    Optional<List<OrderDto>> getByDate(LocalDateTime date);
    Optional<List<OrderDto>> getByMethodIn(List<String> methods);

    Optional<List<OrderDto>> getCustomerOrders(String idCostumer);

    /* IOrderSummary getSummary(int idOrder);

    boolean saveRandomOrder(String idCustomer, String method); */
}
