package com.example.cartservice.domain.dto.removeCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveCartRequest {
    private String requestId;
    private String item;
}
