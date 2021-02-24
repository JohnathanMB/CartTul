package com.johnathanmb.CartTul.service;

import com.johnathanmb.CartTul.model.ProductsByCar;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;

public interface CartService {

    ResponseProductsByCart consult(String id);
}
