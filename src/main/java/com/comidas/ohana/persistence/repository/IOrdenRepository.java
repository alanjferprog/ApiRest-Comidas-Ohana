package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.persistence.entity.Orden;
import com.comidas.ohana.persistence.projection.IOrdenSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdenRepository extends ListCrudRepository<Orden, Integer>
{
    List<Orden> findAllByFechaAfter(LocalDateTime date);
    List<Orden> findAllByMetodoIn(List<String> methods);

    @Query(value = "SELECT * FROM ordenes WHERE id_cliente = :id", nativeQuery = true)
    List<Orden> findCustomerOrders(@Param("id") String idCostumer);

    @Query(value =
            "SELECT po.id_orden AS idOrder, cu.nombre AS customerName, po.fecha AS orderDate, " +
                    "po.total AS orderTotal, GROUP_CONCAT(pi.nombre) AS foodNames " +
                    "FROM ordenes po " +
                    "INNER JOIN clientes cu ON po.id_cliente = cu.id_cliente " +
                    "INNER JOIN items_orden oi ON po.id_orden = oi.id_orden " +
                    "INNER JOIN comidas pi ON oi.id_comida = pi.id_comida " +
                    "WHERE po.id_orden = :ordenId " +
                    "GROUP BY po.id_orden, cu.nombre, po.fecha, po.total;", nativeQuery = true)
    IOrdenSummary findSummary(@Param("ordenId") int idOrder);
}
