package com.johnathanmb.CartTul.model;

import lombok.*;

/**
 * Modelo de producto una vez ingresado en un carrito
 *
 * @author ja.monsalve.bello@gmail.com
 * @since JDK 1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductInCart extends Product {
    private int quantity;
}
