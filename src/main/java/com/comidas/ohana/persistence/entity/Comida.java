package com.comidas.ohana.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comidas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comida
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comida", nullable = false)
    private int idComida;

    @Column(nullable = false, length = 30, unique = true)
    private String nombre;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double precio;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean disponible;
}
