package com.johnathanmb.CartTul.handler;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.util.BuildedObjects;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.util.Util;
import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;

public class GenericResponseAddProduct implements Serializable {

    public static GenericResponse mapResponse(RequestProductInCart requestProductInCart, Cart cart, Product product, ArrayList<ProductByCart> productByCartList, int countCart) {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccessResponse();
        try{
            if (product != null ){

                if(cart == null){

                    cart = new Cart(Util.createId(countCart+1), CartConstants.CART_STATUS_PENDING);
                }

                productByCartList.add(new ProductByCart(product.getId(), cart.getId(), requestProductInCart.getQuantity()));
                genericResponse.setData(productByCartList.get(productByCartList.size()-1));
            }else{
                genericResponse.setData(CartConstants.ERROR_CODE_NOT_FOUND);
                genericResponse.setMessage(CartConstants.ERROR_MESSAGE_PROD_NOT_FOUND);
            }


        }catch (Exception e){
            genericResponse.setErrorResponse(e);
        }

        return genericResponse;
    }

}
