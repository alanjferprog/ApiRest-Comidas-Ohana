package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.dto.FoodDto;
import com.comidas.ohana.domain.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/foods")
public class FoodController
{
    FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodDto>> getAll()
    {
        return this.foodService.getAll().filter(Predicate.not(List::isEmpty))
                .map(foods -> new ResponseEntity<>(foods, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idFood}")
    public ResponseEntity<FoodDto> get(@PathVariable int idFood)
    { return ResponseEntity.ok(this.foodService.get(idFood));}

    @PostMapping
    public ResponseEntity<?> add(@RequestBody FoodDto food)
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
    public ResponseEntity<?> update(@RequestBody FoodDto food)
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

    @DeleteMapping("/{idFood}")
    public ResponseEntity<?> delete(@PathVariable int idFood)
    {
        try {
            if (this.foodService.exists(idFood))
            {
                this.foodService.delete(idFood);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comida no existe");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/availables")
    public ResponseEntity<List<FoodDto>> getAvailables()
    { return this.foodService.getAvailableByPrice().filter(Predicate.not(List::isEmpty))
            .map(foods -> new ResponseEntity<>(foods, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<FoodDto> getByName(@PathVariable String name)
    { return ResponseEntity.ok(this.foodService.getByName(name)); }

    @GetMapping("cheapest/{price}")
    public ResponseEntity<List<FoodDto>> getLessThanEqual(@PathVariable double price)
    { return this.foodService.getLessThan(price).filter(Predicate.not(List::isEmpty))
            .map(foods -> new ResponseEntity<>(foods, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/withname/{name}")
    public ResponseEntity<List<FoodDto>> getWithName(@PathVariable String name)
    { return this.foodService.getWithName(name).filter(Predicate.not(List::isEmpty))
            .map(foods -> new ResponseEntity<>(foods, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


/*
    @PutMapping("/updateprice")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdateFoodPriceDto dto)
    {
        if (this.foodService.exists(dto.getFoodId())) {
            this.foodService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }



     */
}
