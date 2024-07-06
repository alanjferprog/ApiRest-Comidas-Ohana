package com.comidas.ohana.domain.service;

import com.comidas.ohana.persistence.entity.Orden;
import com.comidas.ohana.persistence.projection.IOrdenSummary;
import com.comidas.ohana.persistence.repository.IOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrdenService
{
    private final IOrdenRepository ordenRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    public OrdenService(IOrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> getAll()
    { return this.ordenRepository.findAll(); }

    public List<Orden> getTodayOrders()
    {   LocalDateTime today= LocalDate.now().atTime(0,0);
        return this.ordenRepository.findAllByFechaAfter(today);
    }

    public List<Orden> getOutsideOrders()
    {   List<String> methods= Arrays.asList(DELIVERY, CARRYOUT);
        return this.ordenRepository.findAllByMetodoIn(methods);
    }

    public List<Orden> getCustomerOrders(String idCostumer)
    { return this.ordenRepository.findCustomerOrders(idCostumer); }

    public IOrdenSummary getSummary(int orderId)
    { return this.ordenRepository.findSummary(orderId); }
}
