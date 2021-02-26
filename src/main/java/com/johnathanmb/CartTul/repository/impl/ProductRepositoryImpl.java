package com.johnathanmb.CartTul.repository.impl;

import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.repository.ProductRepository;
import com.johnathanmb.CartTul.util.BuildedObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private BuildedObjects buildedObjects;

    @Override
    public Product findById(String id) {
        return buildedObjects.getProductList().stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }
}
