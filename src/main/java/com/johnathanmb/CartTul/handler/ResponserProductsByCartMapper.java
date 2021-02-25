package com.johnathanmb.CartTul.handler;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.model.ProductInCart;
import com.johnathanmb.CartTul.vo.ResponseProductsByCart;

import java.util.ArrayList;

public class ResponserProductsByCartMapper {

    public static ResponseProductsByCart mapResponse(Cart cart, ArrayList<ProductByCart> productByCartList, ArrayList<Product> productsList){

        ArrayList<ProductInCart> productInCartList = new ArrayList<>();
        for (int i=0; i<productByCartList.size(); i++){
            productInCartList.add(new ProductInCart(
                    productsList.get(i).getId(),
                    productsList.get(i).getName(),
                    productsList.get(i).getSku(),
                    productsList.get(i).getDescription(),
                    productByCartList.get(i).getQuantity()
            ));
        }

        ResponseProductsByCart responseProductsByCart = new ResponseProductsByCart();
        responseProductsByCart.setCart(cart);
        responseProductsByCart.setProducts(productInCartList);
        return responseProductsByCart;
    }

}
