package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.Product;

public interface ProductRepository {
    Product findById(String id);
}
