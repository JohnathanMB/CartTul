package com.johnathanmb.CartTul.repository.impl;

import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.repository.ProductByCartRepository;
import com.johnathanmb.CartTul.util.BuildedObjects;
import com.johnathanmb.CartTul.vo.RequestProductInCart;
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
                .filter(productByCart -> cardId.equals(productByCart.getCartId()))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<ProductByCart> getAll() {
        return buildedObjects.getProductByCartList();
    }

    @Override
    public void saveProductByCart(ProductByCart productByCart) {
        buildedObjects.getProductByCartList().add(productByCart);
    }

    @Override
    public ProductByCart findByCartIdProducId(ProductByCart productByCart) {
        return buildedObjects.getProductByCartList().stream()
                .filter(productByCartFilter -> productByCartFilter.getCartId().equals(productByCart.getCartId()) && productByCartFilter.getProductId().equals(productByCart.getProductId()))
                .findFirst()
                .orElse(null);

    }

    @Override
    public void deleteProductByCar(ProductByCart productByCart) {
        buildedObjects.getProductByCartList().remove(
                this.findByCartIdProducId(productByCart)
        );
    }

    @Override
    public void modifyProductInCart(RequestProductInCart requestProductInCart) {
        try {
            this.findByCartIdProducId(requestProductInCart).setQuantity(requestProductInCart.getQuantity());
        }catch (Exception e){
            return;
        }

    }


}
