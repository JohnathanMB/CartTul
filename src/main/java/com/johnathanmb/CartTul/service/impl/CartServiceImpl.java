package com.johnathanmb.CartTul.service.impl;

import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {



    @Override
    public ResponseProductsByCart consult(String id) {
        return new ResponseProductsByCart();
    }
}
