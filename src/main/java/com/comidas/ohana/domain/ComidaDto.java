package com.comidas.ohana.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComidaDto
{
    private int idComdia;
    private String nombre;
    private double precio;
    private boolean disponible;
}
