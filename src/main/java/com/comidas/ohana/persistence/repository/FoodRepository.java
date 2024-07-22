package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.repository.IFoodDtoRepository;
import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.crud.IFoodCrudRepository;
import com.comidas.ohana.persistence.entity.Food;
import com.comidas.ohana.persistence.mapper.IFoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository implements IFoodDtoRepository
{

    @Autowired
    private IFoodCrudRepository foodCrudRepository;
    @Autowired
    private IFoodMapper foodMapper;

    @Override
    public Optional<List<FoodDto>> getAll()
    {
        List<Food> foods= (List<Food>) foodCrudRepository.findAll();
        return Optional.of(foodMapper.toFoodsDto(foods));
    }

    @Override
    public Optional<FoodDto> get(Integer foodId) {
        Optional<Food> food= foodCrudRepository.findById(foodId);
        return food.map(f -> foodMapper.toFoodDto(f));
    }

    @Override
    public FoodDto save(FoodDto foodDto)
    {   Food food= foodMapper.toFood(foodDto);
        return foodMapper.toFoodDto(foodCrudRepository.save(food));
    }

    public boolean exists(Integer foodId)
    { return foodCrudRepository.existsById(foodId); }

    public void delete(Integer foodId)
    { foodCrudRepository.deleteById(foodId); }

    @Override
    public Optional<List<FoodDto>> getAvailablesByPrice()
    {
        Optional<List<Food>> foods = foodCrudRepository.findAllByAvailableTrueOrderByPrice();
        return foods.map(food -> foodMapper.toFoodsDto(food));
    }

    @Override
    public Optional<FoodDto> getByName(String name)
    {
        Optional<Food> food= foodCrudRepository.findFirstByAvailableTrueAndNameIgnoreCase(name);
        return food.map( f -> foodMapper.toFoodDto(f));
    }

    @Override
    public Optional<List<FoodDto>> getByPriceLessThanEqual(double price)
    {
        Optional<List<Food>> foods= foodCrudRepository.findAllByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
        return foods.map(food -> foodMapper.toFoodsDto(food));
    }

    @Override
    public Optional<List<FoodDto>> getByNameContains(String name)
    {
        Optional<List<Food>> foods= foodCrudRepository.findAllByAvailableTrueAndNameContainingIgnoreCase(name);
        return foods.map(food -> foodMapper.toFoodsDto(food));
    }



    @Override
    public void updatePrice(UpdateFoodPriceDto newFoodPrice)
    { foodCrudRepository.updatePrice(newFoodPrice); }
}
