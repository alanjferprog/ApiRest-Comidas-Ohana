package com.comidas.ohana.domain.service;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.persistence.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Optional<List<FoodDto>> getAll() {
        return this.foodRepository.getAll();
    }

    public FoodDto get(int id)
    { return this.foodRepository.get(id).orElse(null);}

    public FoodDto save(FoodDto foodDto)
    { return this.foodRepository.save(foodDto); }

    public boolean exists(int idFood)
    { return this.foodRepository.exists(idFood); }

    public void delete(int idFood)
    { this.foodRepository.delete(idFood); }



    /* @Transactional
    public void delete(int idFood)
    { this.foodDtoRepository.deleteById(idFood); }

    */

    public Optional<List<FoodDto>> getAvailableByPrice() {
        return this.foodRepository.getAvailablesByPrice();
    }

    public FoodDto getByName(String name)
    {
        return this.foodRepository.getByName(name).
                orElseThrow(() -> new RuntimeException("La comida no existe"));
    }

    public Optional<List<FoodDto>> getLessThan(double price)
    { return this.foodRepository.getByPriceLessThanEqual(price); }

    /*
    @Transactional
    public void updatePrice(UpdateFoodPriceDto dto)
    { this.foodDtoRepository.updatePrice(dto); }

     */

}
