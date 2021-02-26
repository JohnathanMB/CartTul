package com.johnathanmb.CartTul.rest;

import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CartConstants.CART_SERVICE)
@CrossOrigin
public class CartServiceController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = CartConstants.LIST_PRODUCTS_IN_CART, method = RequestMethod.GET)
    public GenericResponse listProductsInCart(@PathVariable("cartID") String cartID){
        return cartService.consult(cartID);
    }

    @RequestMapping(value = CartConstants.ADD_PRODCUT_IN_CART, method = RequestMethod.POST)
    public GenericResponse addProductInCart(@RequestBody RequestProductInCart requestProductInCart){
        return cartService.addProduct(requestProductInCart);
    }

    @RequestMapping(value = CartConstants.CHECKOUT_CART, method = RequestMethod.GET)
    public GenericResponse checkoutCart(@PathVariable("cartID") String cartID){
        return cartService.checkoutCart(cartID);
    }

}
