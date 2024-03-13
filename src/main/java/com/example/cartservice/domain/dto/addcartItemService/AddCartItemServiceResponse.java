package com.example.cartservice.domain.dto.addcartItemService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartItemServiceResponse {
    private String responseId;
    private String resultCode;
    private String resultDesc;
}
