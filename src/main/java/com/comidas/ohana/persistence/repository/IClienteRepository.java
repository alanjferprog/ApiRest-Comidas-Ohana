package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends ListCrudRepository<Cliente, String>
{
    @Query(value = "SELECT c FROM Cliente c WHERE c.numTelefono = :phone")
    Cliente findByPhone(@Param("phone") String phone);
}
