package com.comidas.ohana.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemOrdenDto
{
    private int idOrden;
    private int idItem;
    private int idComida;
    private Double cantidad;
    private Double precio;
    private OrdenDto orden;
    private ComidaDto comida;

}
