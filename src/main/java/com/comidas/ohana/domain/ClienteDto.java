package com.comidas.ohana.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto
{
    private String idCliente;
    private String nombre;
    private String direccion;
    private String email;
    private String numTelefono;
}
