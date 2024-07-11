package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.FoodService;
import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController
{
    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAll()
    { return ResponseEntity.ok(this.foodService.getAll()); }

    @GetMapping("/{idComida}")
    public ResponseEntity<Food> get(@PathVariable int idComida)
    { return ResponseEntity.ok(this.foodService.getById(idComida));}

    @GetMapping("/availables")
    public ResponseEntity<List<Food>> getAvailables()
    { return ResponseEntity.ok(this.foodService.getAllAvailableOrderByPrice()); }

    @GetMapping("/name/{name}")
    public ResponseEntity<Food> getByName(@PathVariable String name)
    { return ResponseEntity.ok(this.foodService.getByName(name)); }

    @GetMapping("cheapest/{price}")
    public  ResponseEntity<List<Food>> getLessThanEqual(@PathVariable double price)
    { return ResponseEntity.ok(this.foodService.getLessThan(price)); }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Food food)
    {
        try {
            if (food.getFoodId() == null || !this.foodService.exists(food.getFoodId())) {
                return ResponseEntity.ok(this.foodService.save(food));
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).body("La comida ya existe");
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Food food)
    {
        try {
            if (food.getFoodId() != null && this.foodService.exists(food.getFoodId())) {
                return ResponseEntity.ok(this.foodService.save(food));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comida no existe");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/updateprice")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdateFoodPriceDto dto)
    {
        if (this.foodService.exists(dto.getFoodId())) {
            this.foodService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idFood}")
    public ResponseEntity<?> delete(@PathVariable int foodId)
    {
        try {
            if (this.foodService.exists(foodId))
            {   this.foodService.delete(foodId);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comida no existe");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
