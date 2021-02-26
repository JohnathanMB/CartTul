package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.ProductByCart;

import java.util.ArrayList;

public interface ProductByCartRepository {

    public ArrayList<ProductByCart> findByCartId(String cardId);

}
