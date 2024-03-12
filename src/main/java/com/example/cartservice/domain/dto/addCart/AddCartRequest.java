package com.example.cartservice.domain.dto.addCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {
    private String requestId;
    private String item;
}
