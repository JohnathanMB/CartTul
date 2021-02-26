package com.johnathanmb.CartTul.repository.impl;

import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.repository.ProductRepository;
import com.johnathanmb.CartTul.util.BuildedObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Product> getAll() {
        return buildedObjects.getProductList();
    }

    @Override
    public ArrayList<Product> findVariusProducts(ArrayList<ProductByCart> productByCartList) {
        ArrayList<Product> productsList = new ArrayList<>();
        //Esto se debió hacer debido a no utilizar base de datos pero esta lógica no debería ir acá
        productByCartList.forEach(productByCart -> {
            productsList.add(this.findById(productByCart.getProductId()));
        });
        return productsList;
    }


}
