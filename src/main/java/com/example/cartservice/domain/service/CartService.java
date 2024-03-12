package com.example.cartservice.domain.service;

import com.example.cartservice.domain.dto.addCart.AddCartRequest;
import com.example.cartservice.domain.dto.addCart.AddCartResponse;
import com.example.cartservice.domain.dto.removeCart.RemoveCartRequest;
import com.example.cartservice.domain.dto.removeCart.RemoveCartResponse;

public interface CartService {
    AddCartResponse addToCart(AddCartRequest addCartRequest);

    RemoveCartResponse removeToCart(RemoveCartRequest removeCartRequest);
}
