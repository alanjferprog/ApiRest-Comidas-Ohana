package com.comidas.ohana.persistence.crud;

import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Food;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFoodCrudRepository extends CrudRepository<Food, Integer>
{
    Optional<List<Food>> findAllByAvailableTrueOrderByPrice();
    Optional<Food> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    Optional<List<Food>> findAllByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    Optional<List<Food>> findAllByAvailableTrueAndNameContainingIgnoreCase(String name);

    @Query(value =
            "UPDATE foods " +
                    "SET price = :#{#newFoodPrice.newPrice} " +
                    "WHERE id_food = :#{#newFoodPrice.foodId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newFoodPrice") UpdateFoodPriceDto newFoodPrice);
}
