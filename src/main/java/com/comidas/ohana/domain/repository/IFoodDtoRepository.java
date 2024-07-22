package com.comidas.ohana.domain.repository;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;

import java.util.List;
import java.util.Optional;

public interface IFoodDtoRepository
{
    Optional<List<FoodDto>> getAll();
    Optional<FoodDto> get(Integer foodId);
    FoodDto save(FoodDto foodDto);
    Optional<List<FoodDto>> getAvailablesByPrice();
    Optional<FoodDto> getByName(String name);
    Optional<List<FoodDto>> getByPriceLessThanEqual(double price);
    Optional<List<FoodDto>> getByNameContains(String name);


    void updatePrice(UpdateFoodPriceDto newFoodPrice);

}
