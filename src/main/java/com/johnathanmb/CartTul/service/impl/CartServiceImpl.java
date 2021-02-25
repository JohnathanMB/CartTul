package com.johnathanmb.CartTul.service.impl;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.ProductInCart;
import com.johnathanmb.CartTul.model.ProductByCar;
import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {



    @Override
    public ResponseProductsByCart consult(String id) {
        Cart cartToBuy = Cart.builder()
                .id("2021-02-01")
                .status("pending").build();
        ProductInCart productInCartOne = (ProductInCart) ProductInCart.builder().quantity(3)
                .id("TAL-PER-101")
                .name("Taladro Percutor Marca")
                .sku("TAL-PER-MARCA")
                .description("Taladro Percutor Marca")
                .build();
        ProductInCart productInCartTwo = (ProductInCart) ProductInCart.builder().quantity(3)
                .id("BAL-CER-101")
                .name("Baldosa de cerámica blanca")
                .sku("BAL-CER-M2")
                .description("Baldosa de cerámica blanca Por metro cuadrado")
                .build();
        ProductInCart productInCartThree = (ProductInCart) ProductInCart.builder().quantity(3)
                .id("KIT-DEST-10-101")
                .name("Kit de Destornilladores")
                .sku("KIT-DEST-10")
                .description("Kit de 10 Destornilladores con punta magnética")
                .build();
        ArrayList<ProductInCart> productInCartList = new ArrayList<>();
        productInCartList.add(productInCartOne);
        productInCartList.add(productInCartTwo);
        productInCartList.add(productInCartThree);
        return new ResponseProductsByCart(productInCartList, cartToBuy);
    }
}
