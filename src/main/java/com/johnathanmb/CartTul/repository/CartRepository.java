package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.Cart;

public interface CartRepository {
    Cart findById(String id);
}
