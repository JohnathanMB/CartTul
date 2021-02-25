package com.johnathanmb.CartTul.service.impl;

import com.johnathanmb.CartTul.handler.ResponserProductsByCartMapper;
import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
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
                .status("pending")
                .build();

        ProductByCart productByCart1 = ProductByCart.builder()
                .carId("2021-02-01")
                .productId("TAL-PER-101")
                .quantity(3)
                .build();

        ProductByCart productByCart2 = ProductByCart.builder()
                .carId("2021-02-01")
                .productId("BAL-CER-101")
                .quantity(2)
                .build();

        ProductByCart productByCart3 = ProductByCart.builder()
                .carId("2021-02-01")
                .productId("KIT-DEST-10-101")
                .quantity(5)
                .build();

        Product product1 = Product.builder()
                .id("TAL-PER-101")
                .name("Taladro Percutor Marca")
                .sku("TAL-PER-MARCA")
                .description("Taladro Percutor Marca")
                .build();
        Product product2 = Product.builder()
                .id("BAL-CER-101")
                .name("Baldosa de cerámica blanca")
                .sku("BAL-CER-M2")
                .description("Baldosa de cerámica blanca Por metro cuadrado")
                .build();
        Product product3 = Product.builder()
                .id("KIT-DEST-10-101")
                .name("Kit de Destornilladores")
                .sku("KIT-DEST-10")
                .description("Kit de 10 Destornilladores con punta magnética")
                .build();

        ArrayList <ProductByCart> productByCartList = new ArrayList<>();
        productByCartList.add(productByCart1);
        productByCartList.add(productByCart2);
        productByCartList.add(productByCart3);

        ArrayList <Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return ResponserProductsByCartMapper.mapResponse(cartToBuy, productByCartList, productList);
    }
}
