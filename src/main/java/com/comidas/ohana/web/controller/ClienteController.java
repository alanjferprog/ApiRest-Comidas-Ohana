package com.comidas.ohana.web.controller;

import com.comidas.ohana.domain.service.ClienteService;
import com.comidas.ohana.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController
{
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/byphone/{phone}")
    public ResponseEntity<Cliente> getByPhone(@PathVariable("phone") String phone)
    { return ResponseEntity.ok(this.clienteService.findByPhone(phone)); }
}
