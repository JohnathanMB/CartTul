package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;

public interface CartService {
    GenericResponse consult(String id);

    GenericResponse addProduct(RequestProductInCart requestProductInCart);
}
