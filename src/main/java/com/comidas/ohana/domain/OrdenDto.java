package com.comidas.ohana.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrdenDto
{
    private int idOrden;
    private String idCliente;
    private LocalDateTime fecha;
    private Double total;
    private String metodo;
    private String notaAdiconal;
    private ClienteDto cliente;
    private List<ItemOrdenDto> items;
}
