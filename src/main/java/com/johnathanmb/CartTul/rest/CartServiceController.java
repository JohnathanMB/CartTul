package com.johnathanmb.CartTul.rest;

import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CartConstants.CART_SERVICE)
@CrossOrigin
public class CartServiceController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = CartConstants.LIST_PRODUCTS_IN_CART, method = RequestMethod.GET)
    public ResponseProductsByCart listProductsInCart(){
        return cartService.consult("1");
    }

}
