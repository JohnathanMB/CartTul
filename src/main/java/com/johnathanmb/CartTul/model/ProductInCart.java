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
public class ProductInCart extends Product {
    private int quantity;

    public ProductInCart(String id, String name, String sku, String description, int quantity) {
        super(id, name, sku, description);
        this.quantity = quantity;
    }
}
