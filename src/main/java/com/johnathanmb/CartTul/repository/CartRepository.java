package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.Cart;

import java.util.ArrayList;

public interface CartRepository {

    public Cart findById(String id);
    public ArrayList<Cart> getAll();
    public int getCount();
    public void saveCart(Cart cart);
}
