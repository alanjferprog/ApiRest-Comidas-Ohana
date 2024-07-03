package com.comidas.ohana.domain.service;

import com.comidas.ohana.persistence.entity.Comida;
import com.comidas.ohana.persistence.repository.IComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {
    IComidaRepository comidaRepository;

    @Autowired
    public ComidaService(IComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    public List<Comida> getAll() {
        return comidaRepository.findAll();
    }

    public List<Comida> getAllAvailableOrderByPrice() {
        return comidaRepository.findAllByDisponibleTrueOrderByPrecio();
    }

    public Comida getByName(String name)
    {
        return comidaRepository.findFirstByDisponibleTrueAndNombreIgnoreCase(name).
                orElseThrow(() -> new RuntimeException("La comida no existe"));
    }

    public List<Comida> getLessThan(double price)
    { return comidaRepository.findAllByDisponibleTrueAndPrecioLessThanEqualOrderByPrecioAsc(price); }
}
