package com.johnathanmb.CartTul.service.impl;

import com.johnathanmb.CartTul.handler.GenericResponseMapper;
import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.repository.impl.CartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductByCartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductRepositoryImpl;
import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepositoryImpl cartRepository;
    @Autowired
    private ProductByCartRepositoryImpl productByCartRepository;
    @Autowired
    private ProductRepositoryImpl productRepository;

    @Override
    public GenericResponse consult(String id) {
        //consulta en repositorios
        Cart cart = cartRepository.findById(id);
        ArrayList<ProductByCart> productByCartList = productByCartRepository.findByCartId(id);
        ArrayList<Product> productsList = productRepository.findVariusProducts(productByCartList);

        return GenericResponseMapper.mapProductByCartResponse(cart, productByCartList, productsList);
    }

    @Override
    public GenericResponse addProduct(RequestProductInCart requestProductInCart) {
        //consulta en repositorios
        Cart cart = cartRepository.findById(requestProductInCart.getCartId());
        ArrayList<ProductByCart> productByCartList = productByCartRepository.findByCartId(requestProductInCart.getCartId());
        Product product = productRepository.findById(requestProductInCart.getProductId());
        int countCarts = cartRepository.getCount();

        GenericResponse genericResponse = GenericResponseMapper.mapAddProductResponse(requestProductInCart, cart, product, productByCartList, countCarts);
        //Esta parte de la lógica no debería ir acá, se debe poner por la falta de uso de base de datos
        if (genericResponse.getCode() == CartConstants.SUCCESS_CODE){
            cartRepository.saveCart(new Cart(((ProductByCart)genericResponse.getData()).getCartId(), CartConstants.CART_STATUS_PENDING));
            productByCartRepository.saveProductByCart((ProductByCart) genericResponse.getData());
        }

        return genericResponse;
    }

    @Override
    public GenericResponse checkoutCart(String cartID) {
        cartRepository.checkout(cartID);
        return this.consult(cartID);
    }
}
