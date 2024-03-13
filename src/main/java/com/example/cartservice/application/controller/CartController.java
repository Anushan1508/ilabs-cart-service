package com.example.cartservice.application.controller;

import com.example.cartservice.domain.dto.addCart.AddCartRequest;
import com.example.cartservice.domain.dto.addCart.AddCartResponse;
import com.example.cartservice.domain.dto.removeCart.RemoveCartRequest;
import com.example.cartservice.domain.dto.removeCart.RemoveCartResponse;
import com.example.cartservice.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${base-url-context}")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addtocart")
    public ResponseEntity<AddCartResponse> addToCart(@RequestBody AddCartRequest addCartRequest){
        return ResponseEntity.ok(cartService.addToCart(addCartRequest));
    }

    @PostMapping("/removetocart")
    public ResponseEntity<RemoveCartResponse> removeToCart(@RequestBody RemoveCartRequest removeCartRequest){
        System.out.println("removeCartRequest = " + removeCartRequest);
        return ResponseEntity.ok(cartService.removeToCart(removeCartRequest));
    }
}
