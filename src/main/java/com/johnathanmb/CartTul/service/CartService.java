package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;

public interface CartService {
    public GenericResponse consult(String id);

    public GenericResponse addProduct(RequestProductInCart requestProductInCart);

    public GenericResponse checkoutCart(String cartId);

    public GenericResponse deleteProductInCart(RequestProductInCart requestProductInCart);
}
