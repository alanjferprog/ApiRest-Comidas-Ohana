package com.comidas.ohana.persistence.crud;

import com.comidas.ohana.persistence.entity.Order;
import com.comidas.ohana.persistence.projection.IOrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderCrudRepository extends CrudRepository<Order,Integer>
{
    Optional<List<Order>> findAllByDateAfter(LocalDateTime date);
    Optional<List<Order>> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM orders WHERE id_customer = :id", nativeQuery = true)
    Optional<List<Order>> findCustomerOrders(@Param("id") String idCostumer);

    /* @Query(value =
            "SELECT po.id_order AS idOrder, cu.name AS customerName, po.date AS orderDate, " +
                    "po.total AS orderTotal, GROUP_CONCAT(pi.name) AS foodNames " +
                    "FROM orders po " +
                    "INNER JOIN customers cu ON po.id_customer = cu.id_customer " +
                    "INNER JOIN order_items oi ON po.id_order = oi.id_order " +
                    "INNER JOIN foods pi ON oi.id_food = pi.id_food " +
                    "WHERE po.id_order = :ordenId " +
                    "GROUP BY po.id_order, cu.name, po.date, po.total;", nativeQuery = true)
    IOrderSummary findSummary(@Param("ordenId") int idOrder);

    @Procedure(value = "saturday_party_random_food", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method); */
}
