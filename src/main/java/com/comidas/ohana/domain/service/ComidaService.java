package com.comidas.ohana.domain.service;

import com.comidas.ohana.domain.service.dto.UpdateFoodPriceDto;
import com.comidas.ohana.persistence.entity.Comida;
import com.comidas.ohana.persistence.repository.IComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Comida getById(int id)
    { return this.comidaRepository.findById(id).orElse(null);}

    public Comida save(Comida pizzaEntity)
    { return this.comidaRepository.save(pizzaEntity); }

    @Transactional
    public void delete(int idFood)
    { this.comidaRepository.deleteById(idFood); }

    public boolean exists(int idFood)
    { return this.comidaRepository.existsById(idFood); }

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

    /* @Transactional(noRollbackFor = EmailApiException.class)
    public void updatePrice(UpdateFoodPriceDto dto)
    { this.comidaRepository.updatePrice(dto);
        this.sendEmail();}

     */
    @Transactional
    public void updatePrice(UpdateFoodPriceDto dto)
    { this.comidaRepository.updatePrice(dto); }
}
