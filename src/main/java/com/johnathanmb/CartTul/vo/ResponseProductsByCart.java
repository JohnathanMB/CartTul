package com.johnathanmb.CartTul.vo;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.ProductInCart;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseProductsByCart implements Serializable {
    private ArrayList<ProductInCart> products;
    private Cart cart;
}
