package com.comidas.ohana.persistence.repository;

import com.comidas.ohana.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends ListCrudRepository<Customer, String>
{
    @Query(value = "SELECT c FROM Customer c WHERE c.phoneNumber = :phone")
    Customer findByPhone(@Param("phone") String phone);
}