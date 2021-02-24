package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.service.impl.CartServiceImpl;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CartServiceTest {

    private final CartService cartService = new CartServiceImpl();

    @Test
    public void returnCartNotNullWhitID(){
        //Give
        String cartId = "2021-02-01";

        //When
        ResponseProductsByCart productsByCart = cartService.consult(cartId);

        //Then
        assertNotNull(productsByCart);
    }



}