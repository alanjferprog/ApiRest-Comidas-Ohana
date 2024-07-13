package com.comidas.ohana.persistence.crud;

import com.comidas.ohana.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerCrudRepository extends CrudRepository<Customer,String>
{
    @Query(value = "SELECT c FROM Customer c WHERE c.phoneNumber = :phone")
    Optional<Customer> findByPhone(@Param("phone") String phone);
}
