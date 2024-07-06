package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.ComidaService;
import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Comida;
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
@RequestMapping("/api/comidas")
public class ComidaController
{
    ComidaService comidaService;

    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comida>> getAll()
    { return ResponseEntity.ok(this.comidaService.getAll()); }

    @GetMapping("/{idComida}")
    public ResponseEntity<Comida> get(@PathVariable int idComida)
    { return ResponseEntity.ok(this.comidaService.getById(idComida));}

    @GetMapping("/disponibles")
    public ResponseEntity<List<Comida>> getAllDisponibles()
    { return ResponseEntity.ok(this.comidaService.getAllAvailableOrderByPrice()); }

    @GetMapping("/name/{name}")
    public ResponseEntity<Comida> getByName(@PathVariable String name)
    { return ResponseEntity.ok(this.comidaService.getByName(name)); }

    @GetMapping("cheapest/{price}")
    public  ResponseEntity<List<Comida>> getLessThanEqual(@PathVariable double price)
    { return ResponseEntity.ok(this.comidaService.getLessThan(price)); }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Comida comida)
    {
        try {
            if (comida.getIdComida() == null || !this.comidaService.exists(comida.getIdComida())) {
                return ResponseEntity.ok(this.comidaService.save(comida));
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).body("La comida ya existe");
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Comida comida)
    {
        try {
            if (comida.getIdComida() != null && this.comidaService.exists(comida.getIdComida())) {
                return ResponseEntity.ok(this.comidaService.save(comida));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comida no existe");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/updateprice")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdateFoodPriceDto dto)
    {
        if (this.comidaService.exists(dto.getFoodId())) {
            this.comidaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<?> delete(@PathVariable int idComida)
    {
        try {
            if (this.comidaService.exists(idComida))
            {   this.comidaService.delete(idComida);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La comida no existe");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
