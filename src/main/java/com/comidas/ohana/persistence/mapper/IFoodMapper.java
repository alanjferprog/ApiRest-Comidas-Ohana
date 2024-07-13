package com.comidas.ohana.persistence.mapper;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.persistence.entity.Food;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFoodMapper
{

    FoodDto toFoodDto(Food food);
    List<FoodDto> toFoodsDto(List<Food> foods);

    Food toFood(FoodDto foodDto);
    List<Food> toFoods(List<FoodDto> foodDtos);
}
