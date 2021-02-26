package com.johnathanmb.CartTul.repository.impl;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.repository.CartRepository;
import com.johnathanmb.CartTul.util.BuildedObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {

    @Autowired
    private BuildedObjects buildedObjects;

    @Override
    public Cart findById(String id) {
        return buildedObjects.getCartList().stream()
                .filter(cart -> id.equals(cart.getId()))
                .findFirst()
                .orElse(null);
    }
}
