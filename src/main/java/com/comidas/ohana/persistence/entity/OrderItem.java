package com.comidas.ohana.persistence.entity;

import com.comidas.ohana.persistence.audit.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_items")
@EntityListeners(AuditingEntityListener.class)
@IdClass(OrderItemID.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends AuditableEntity
{
    @Id
    @Column(name = "id_order", nullable = false)
    private int orderId;

    @Id
    @Column(name = "id_item", nullable = false)
    private int itemId;

    @Column(name = "id_food", nullable = false)
    private int foodId;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    @JsonIgnore
    private Order order;

    @OneToOne
    @JoinColumn(name = "id_food", referencedColumnName = "id_food",insertable = false, updatable = false)
    private Food food;


}
