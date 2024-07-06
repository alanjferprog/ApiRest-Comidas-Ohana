package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.OrdenService;
import com.comidas.ohana.persistence.entity.Orden;
import com.comidas.ohana.persistence.projection.IOrdenSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController
{
    private final OrdenService ordenService;

    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    public ResponseEntity<List<Orden>> getAll()
    { return ResponseEntity.ok(this.ordenService.getAll()); }

    @GetMapping("/today")
    public ResponseEntity<List<Orden>> getTodayOrders()
    { return ResponseEntity.ok(this.ordenService.getTodayOrders()); }

    @GetMapping("/outside")
    public ResponseEntity<List<Orden>> getOutsideOrders()
    { return ResponseEntity.ok(this.ordenService.getOutsideOrders()); }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Orden>> getCustomerOrders(@PathVariable String id)
    { return ResponseEntity.ok(this.ordenService.getCustomerOrders(id)); }

    @GetMapping("/summary/{idorden}")
    public ResponseEntity<IOrdenSummary> getSummary(@PathVariable int idorden)
    { return ResponseEntity.ok(this.ordenService.getSummary(idorden)); }
}
