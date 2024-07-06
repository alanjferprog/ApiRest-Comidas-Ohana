package com.comidas.ohana.persistence.projection;

import java.time.LocalDateTime;

public interface IOrdenSummary
{
    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getFoodNames();
}
