package com.johnathanmb.CartTul.model;

import lombok.*;

/**
 * Modelo de relación entre producto y cart de base de datos
 *
 * @author ja.monsalve.bello@gmail.com
 * @since JDK 1.8
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductByCart {
    private String productId;
    private String cartId;
    private int quantity;
}
