package com.johnathanmb.CartTul.service.impl;

import com.johnathanmb.CartTul.handler.ResponserProductsByCartMapper;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.repository.impl.CartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductByCartRepositoryImpl;
import com.johnathanmb.CartTul.repository.impl.ProductRepositoryImpl;
import com.johnathanmb.CartTul.service.CartService;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;
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
    public ResponseProductsByCart consult(String id) {

        ArrayList<ProductByCart> productByCartList = productByCartRepository.findByCartId(id);
        ArrayList<Product> productList = new ArrayList<>();
        productByCartList.forEach(productByCart -> {
            productList.add(productRepository.findById(productByCart.getProductId()));
        });

        return ResponserProductsByCartMapper.mapResponse(
                cartRepository.findById(id),
                productByCartList,
                productList);
    }
}
