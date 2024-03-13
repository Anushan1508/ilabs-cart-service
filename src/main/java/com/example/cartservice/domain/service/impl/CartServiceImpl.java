package com.example.cartservice.domain.service.impl;

import com.example.cartservice.domain.dto.addCart.AddCartRequest;
import com.example.cartservice.domain.dto.addCart.AddCartResponse;
import com.example.cartservice.domain.dto.addcartItemService.AddCartItemServiceRequest;
import com.example.cartservice.domain.dto.addcartItemService.AddCartItemServiceResponse;
import com.example.cartservice.domain.dto.removeCart.RemoveCartRequest;
import com.example.cartservice.domain.dto.removeCart.RemoveCartResponse;
import com.example.cartservice.domain.entities.CardEntity;
import com.example.cartservice.domain.service.CartService;
import com.example.cartservice.external.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    private final RestTemplate sslRestTemplate;
    @Value("${itemService.Url}")
    private String itemServiceUrl;

    @Autowired
    public CartServiceImpl(RestTemplate sslRestTemplate, @Value("${itemService.Url}") String itemServiceUrl) {
        this.sslRestTemplate = sslRestTemplate;
        this.itemServiceUrl = itemServiceUrl;
    }

    @Override
    public AddCartResponse addToCart(AddCartRequest addCartRequest) {
        AddCartResponse addCartResponse = new AddCartResponse();
        addCartResponse.setResponseId(addCartRequest.getRequestId());
        AddCartItemServiceRequest addCartItemServiceRequest = new AddCartItemServiceRequest(
                addCartRequest.getRequestId(),
                addCartRequest.getItem()
        );
        HttpEntity<AddCartItemServiceRequest> addCartItemServiceRequestHttpEntity = new HttpEntity<>(addCartItemServiceRequest);
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCartItem(addCartRequest.getItem());
        ResponseEntity<AddCartItemServiceResponse> addCartItemServiceResponseResponseEntity = this.sslRestTemplate
                .exchange(
                        itemServiceUrl,
                        HttpMethod.POST,
                        addCartItemServiceRequestHttpEntity,
                        AddCartItemServiceResponse.class
                );
        if (Objects.nonNull(addCartItemServiceResponseResponseEntity.getBody()) && addCartItemServiceResponseResponseEntity.getBody().getResultCode().equals("200")) {
            try {
                cartRepository.save(cardEntity);
                addCartResponse.setResultCode("200");
                addCartResponse.setResultDesc("Item added to cart successfully");
            } catch (Exception e) {
                addCartResponse.setResultCode("401");
                addCartResponse.setResultDesc("Exception occurred while adding item to cart");
                e.printStackTrace();
            }
        } else {
            addCartResponse.setResultCode("400");
            addCartResponse.setResultDesc("Item not added to cart");
        }
        return addCartResponse;
    }

    @Override
    public RemoveCartResponse removeToCart(RemoveCartRequest removeCartRequest) {
        RemoveCartResponse removeCartResponse = new RemoveCartResponse();
        removeCartResponse.setResponseId(removeCartRequest.getRequestId());
        try {
            int deletedRows = cartRepository.deleteByCartItem(removeCartRequest.getItem());
            if (deletedRows > 0) {
                removeCartResponse.setResultCode("200");
                removeCartResponse.setResultDesc("Item removed from cart successfully");
            } else {
                removeCartResponse.setResultCode("404");
                removeCartResponse.setResultDesc("Item not found in cart");
            }
        } catch (Exception e) {
            removeCartResponse.setResultCode("401");
            removeCartResponse.setResultDesc("Exception occurred while removing item from cart");
            e.printStackTrace();
        }
        return removeCartResponse;
    }
}

