package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Comida;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IComidaRepository extends ListCrudRepository<Comida, Integer>
{
    List<Comida> findAllByDisponibleTrueOrderByPrecio();
    Optional<Comida> findFirstByDisponibleTrueAndNombreIgnoreCase(String name);
    List<Comida> findAllByDisponibleTrueAndPrecioLessThanEqualOrderByPrecioAsc(double price);

    @Query(value =
                    "UPDATE comidas " +
                    "SET precio = :#{#newFoodPrice.newPrice} " +
                    "WHERE id_comida = :#{#newFoodPrice.foodId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newFoodPrice") UpdateFoodPriceDto newFoodPrice);

}
