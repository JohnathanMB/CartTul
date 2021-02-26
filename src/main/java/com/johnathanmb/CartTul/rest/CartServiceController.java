package com.johnathanmb.CartTul.rest;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CartConstants.CART_SERVICE)
@CrossOrigin
@Api(value = "Api Cart", description = "Api para gestión de carrito de compras")
public class CartServiceController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = CartConstants.LIST_PRODUCTS_IN_CART, method = RequestMethod.GET)
    @ApiOperation(value = "Lista información completa en un carrito dado el ID", notes = "Retorna un carrito con id, estado y productos asociados")
    public GenericResponse listProductsInCart(@PathVariable("cartID") String cartID){
        return cartService.consult(cartID);
    }

    @RequestMapping(value = CartConstants.CHECKOUT_CART, method = RequestMethod.GET)
    @ApiOperation(value = "Cambia el estado de un carrito de compra a Completed", notes = "Retorna el carrito de compra actualizado")
    public GenericResponse checkoutCart(@PathVariable("cartID") String cartID){
        return cartService.checkoutCart(cartID);
    }

    @RequestMapping(value = CartConstants.ADD_PRODCUT_IN_CART, method = RequestMethod.POST)
    @ApiOperation(value = "Agrega producto a un carrito", notes = "Retorna un carrito con id, estado y productos asociados, incluyendo los anteriores y el agregado")
    public GenericResponse addProductInCart(@RequestBody RequestProductInCart requestProductInCart){
        return cartService.addProduct(requestProductInCart);
    }

    @RequestMapping(value = CartConstants.DELETE_PRODUCT_IN_CART, method = RequestMethod.POST)
    @ApiOperation(value = "Elimina un producto del carrito", notes = "Retorna un carrito con id, estado y productos asociados sin el producto eliminado")
    public GenericResponse deleteProductInCart(@RequestBody RequestProductInCart requestProductInCart){
        return cartService.deleteProductInCart(requestProductInCart);
    }

    @RequestMapping(value = CartConstants.MODIFY_PRODUCT_IN_CART, method = RequestMethod.PUT)
    @ApiOperation(value = "Cambia la cantidad de un producto en un carrito", notes = "Retorna un carrito con id, estado y productos asociados, incluyendo el producto actualizado")
    public GenericResponse modifyProductInCart(@RequestBody RequestProductInCart requestProductInCart){
        return  cartService.modifyProductInCart(requestProductInCart);
    }

}
