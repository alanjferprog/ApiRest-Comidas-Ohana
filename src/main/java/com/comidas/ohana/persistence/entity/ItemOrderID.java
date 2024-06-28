package com.comidas.ohana.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrderID implements Serializable
{
    private Integer idOrden;
    private Integer idItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrderID that = (ItemOrderID) o;
        return Objects.equals(idOrden, that.idOrden) && Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, idItem);
    }
}
