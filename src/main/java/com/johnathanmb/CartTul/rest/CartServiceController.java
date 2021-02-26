package com.johnathanmb.CartTul.rest;

import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CartConstants.CART_SERVICE)
@CrossOrigin
public class CartServiceController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = CartConstants.LIST_PRODUCTS_IN_CART, method = RequestMethod.GET)
    public ResponseProductsByCart listProductsInCart(@PathVariable("cartID") String cartID){
        return cartService.consult(cartID);
    }

}
