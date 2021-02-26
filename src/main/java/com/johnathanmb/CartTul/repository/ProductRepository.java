package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;

import java.util.ArrayList;

public interface ProductRepository {
    Product findById(String id);
    ArrayList<Product> getAll();
    ArrayList<Product> findVariusProducts(ArrayList<ProductByCart> productByCartList);
}
