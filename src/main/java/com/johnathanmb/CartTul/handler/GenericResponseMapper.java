package com.johnathanmb.CartTul.handler;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.Product;
import com.johnathanmb.CartTul.model.ProductByCart;
import com.johnathanmb.CartTul.util.CartConstants;
import com.johnathanmb.CartTul.util.Util;
import com.johnathanmb.CartTul.vo.GenericResponse;
import com.johnathanmb.CartTul.vo.RequestProductInCart;

import java.util.ArrayList;

public class GenericResponseMapper {

    public static GenericResponse mapProductByCartResponse(Cart cart, ArrayList<ProductByCart> productByCartList, ArrayList<Product> productsList){
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

    public static GenericResponse mapAddProductResponse(RequestProductInCart requestProductInCart, Cart cart, Product product, ArrayList<ProductByCart> productByCartList, int countCart) {
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

    public static GenericResponse mapDeleteProductResponse(GenericResponse genericResponse) {

        if(genericResponse.getData() == null){
            genericResponse.setCode(CartConstants.SUCCESS_CODE);
            genericResponse.setMessage(CartConstants.DELETE_PRODUCT_IN_CART_MESSAGE_VOID);
        }

        return genericResponse;
    }
}
