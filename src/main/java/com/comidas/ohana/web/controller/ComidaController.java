package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.ComidaService;
import com.comidas.ohana.persistence.entity.Comida;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/disponibles")
    public ResponseEntity<List<Comida>> getAllDisponibles()
    { return ResponseEntity.ok(this.comidaService.getAllAvailableOrderByPrice()); }

    @GetMapping("/name/{name}")
    public ResponseEntity<Comida> getByName(@PathVariable String name)
    { return ResponseEntity.ok(this.comidaService.getByName(name)); }

    @GetMapping("cheapest/{price}")
    public  ResponseEntity<List<Comida>> getLessThanEquak(@PathVariable double price)
    { return ResponseEntity.ok(this.comidaService.getLessThan(price)); }
}
