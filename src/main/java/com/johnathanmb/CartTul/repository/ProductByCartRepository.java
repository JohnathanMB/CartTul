package com.johnathanmb.CartTul.repository;

import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.vo.RequestProductInCart;

import java.util.ArrayList;

public interface ProductByCartRepository {

    public ArrayList<ProductByCart> findByCartId(String cardId);

    public ArrayList<ProductByCart> getAll();

    public void saveProductByCart(ProductByCart productByCart);

    public ProductByCart findByCartIdProducId(ProductByCart productByCart);

    public void deleteProductByCar(ProductByCart productByCart);

    public void modifyProductInCart(RequestProductInCart requestProductInCart);
}
