package com.comidas.ohana.domain.service;

import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Food;
import com.comidas.ohana.persistence.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {
    IFoodRepository foodRepository;

    @Autowired
    public FoodService(IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food getById(int id)
    { return this.foodRepository.findById(id).orElse(null);}

    public Food save(Food pizzaEntity)
    { return this.foodRepository.save(pizzaEntity); }

    @Transactional
    public void delete(int idFood)
    { this.foodRepository.deleteById(idFood); }

    public boolean exists(int idFood)
    { return this.foodRepository.existsById(idFood); }

    public List<Food> getAllAvailableOrderByPrice() {
        return foodRepository.findAllByAvailableTrueOrderByPrice();
    }

    public Food getByName(String name)
    {
        return foodRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).
                orElseThrow(() -> new RuntimeException("La comida no existe"));
    }

    public List<Food> getLessThan(double price)
    { return foodRepository.findAllByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price); }

    @Transactional
    public void updatePrice(UpdateFoodPriceDto dto)
    { this.foodRepository.updatePrice(dto); }

}
