package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Food;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFoodRepository extends ListCrudRepository<Food, Integer>
{
    List<Food> findAllByAvailableTrueOrderByPrice();
    Optional<Food> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<Food> findAllByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

    @Query(value =
                    "UPDATE foods " +
                    "SET price = :#{#newFoodPrice.newPrice} " +
                    "WHERE id_food = :#{#newFoodPrice.foodId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newFoodPrice") UpdateFoodPriceDto newFoodPrice);

}
