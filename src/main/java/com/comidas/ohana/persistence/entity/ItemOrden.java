package com.comidas.ohana.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items_orden")
@IdClass(ItemOrderID.class)
@Getter
@Setter
@NoArgsConstructor
public class ItemOrden
{
    @Id
    @Column(name = "id_orden", nullable = false)
    private int idOrden;

    @Id
    @Column(name = "id_item", nullable = false)
    private int idItem;

    @Column(name = "id_comida", nullable = false)
    private int idComida;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double cantidad;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
    @JsonIgnore
    private Orden orden;

    @OneToOne
    @JoinColumn(name = "id_comida", referencedColumnName = "id_comida",insertable = false, updatable = false)
    private Comida comida;


}
