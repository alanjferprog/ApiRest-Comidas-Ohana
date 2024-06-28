package com.comidas.ohana.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente
{
    @Id
    @Column(name = "id_cliente",nullable = false, length = 15)
    private String idCliente;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(length = 100)
    private String direccion;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "numero_telefono",length = 100)
    private String numTelefono;


}
