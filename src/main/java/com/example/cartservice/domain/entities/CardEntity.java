package com.example.cartservice.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart", indexes = {
        @Index(name = "cartItem", columnList = "cartItem")
})
public class CardEntity {
    @Id
    private Long id;
    private String cartItem;
}
