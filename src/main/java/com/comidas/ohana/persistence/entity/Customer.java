package com.comidas.ohana.persistence.entity;

import com.comidas.ohana.persistence.audit.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AuditableEntity
{
    @Id
    @Column(name = "id_customer",nullable = false, length = 15)
    private String customerId;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(length = 100)
    private String addres;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "phone_number",length = 100)
    private String phoneNumber;


}
