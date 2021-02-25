package com.johnathanmb.CartTul.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
public class ProductInCart extends Product {
    private int quantity;
}
