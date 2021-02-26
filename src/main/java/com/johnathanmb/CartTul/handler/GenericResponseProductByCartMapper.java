package com.johnathanmb.CartTul.handler;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.vo.GenericResponse;

import java.io.Serializable;
import java.util.ArrayList;

public class GenericResponseProductByCartMapper implements Serializable {

    public static GenericResponse mapGenericResponse(Cart cart, ArrayList<ProductByCart> productByCartList, ArrayList<Product> productsList){
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccessResponse();
        try{

            if(productByCartList.size() != 0 && productsList.size() != 0 ){
                genericResponse.setData(ResponserProductsByCartMapper.mapResponseProductsByCartMapper(
                        cart,
                        productByCartList,
                        productsList));
            }else{
                genericResponse.setCode(CartConstants.ERROR_CODE_NOT_FOUND);
                genericResponse.setMessage(CartConstants.ERROR_MESSAGE_NOT_FOUND);
            }

        }catch (Exception e){
            genericResponse.setErrorResponse(e);
        }

        return genericResponse;
    }
}
