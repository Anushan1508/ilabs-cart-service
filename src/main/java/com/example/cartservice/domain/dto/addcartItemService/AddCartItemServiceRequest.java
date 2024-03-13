package com.example.cartservice.domain.dto.addcartItemService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartItemServiceRequest {
    private String requestId;
    private String item;
}
