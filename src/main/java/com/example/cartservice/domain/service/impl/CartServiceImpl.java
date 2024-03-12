package com.example.cartservice.domain.service.impl;

import com.example.cartservice.domain.dto.addCart.AddCartRequest;
import com.example.cartservice.domain.dto.addCart.AddCartResponse;
import com.example.cartservice.domain.dto.removeCart.RemoveCartRequest;
import com.example.cartservice.domain.dto.removeCart.RemoveCartResponse;
import com.example.cartservice.domain.service.CartService;
import com.example.cartservice.external.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public AddCartResponse addToCart(AddCartRequest addCartRequest) {
        return null;
    }

    @Override
    public RemoveCartResponse removeToCart(RemoveCartRequest removeCartRequest) {
        return null;
    }
}
