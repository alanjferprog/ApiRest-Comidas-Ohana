package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderRepository extends ListCrudRepository<Order, Integer>
{
    List<Order> findAllByDateAfter(LocalDateTime date);
    List<Order> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM orders WHERE id_customer = :id", nativeQuery = true)
    List<Order> findCustomerOrders(@Param("id") String idCostumer);

    @Query(value =
            "SELECT po.id_order AS idOrder, cu.name AS customerName, po.date AS orderDate, " +
                    "po.total AS orderTotal, GROUP_CONCAT(pi.name) AS foodNames " +
                    "FROM orders po " +
                    "INNER JOIN customers cu ON po.id_customer = cu.id_customer " +
                    "INNER JOIN order_items oi ON po.id_order = oi.id_order " +
                    "INNER JOIN foods pi ON oi.id_food = pi.id_food " +
                    "WHERE po.id_order = :ordenId " +
                    "GROUP BY po.id_order, cu.name, po.date, po.total;", nativeQuery = true)
    IOrderSummary findSummary(@Param("ordenId") int idOrder);
}
