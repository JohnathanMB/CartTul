package com.johnathanmb.CartTul.repository.impl;

import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.repository.ProductByCartRepository;
import com.johnathanmb.CartTul.util.BuildedObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class ProductByCartRepositoryImpl implements ProductByCartRepository {

    @Autowired
    private BuildedObjects buildedObjects = new BuildedObjects();

    @Override
    public ArrayList<ProductByCart> findByCartId(String cardId) {
        return (ArrayList<ProductByCart>) buildedObjects.getProductByCartList().stream()
                .filter(productByCart -> cardId.equals(productByCart.getCarId()))
                .collect(Collectors.toList());
    }
}
