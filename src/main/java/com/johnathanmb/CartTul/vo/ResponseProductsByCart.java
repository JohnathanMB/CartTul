package com.johnathanmb.CartTul.vo;

import com.johnathanmb.CartTul.model.Cart;
import com.johnathanmb.CartTul.model.ProductInCart;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ResponseProductsByCart {
    private ArrayList<ProductInCart> products;
    private Cart cart;
}
