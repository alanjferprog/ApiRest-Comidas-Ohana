package com.comidas.ohana.domain.service;

import com.comidas.ohana.persistence.entity.Cliente;
import com.comidas.ohana.persistence.repository.IClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService
{
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findByPhone(String phone)
    { return this.clienteRepository.findByPhone(phone); }
}
