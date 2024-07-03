package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.persistence.entity.Comida;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface IComidaRepository extends ListCrudRepository<Comida, Integer>
{
    List<Comida> findAllByDisponibleTrueOrderByPrecio();
    Optional<Comida> findFirstByDisponibleTrueAndNombreIgnoreCase(String name);
    List<Comida> findAllByDisponibleTrueAndPrecioLessThanEqualOrderByPrecioAsc(double price);

}
