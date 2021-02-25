package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.vo.ResponseProductsByCart;

public interface CartService {

    ResponseProductsByCart consult(String id);
}
