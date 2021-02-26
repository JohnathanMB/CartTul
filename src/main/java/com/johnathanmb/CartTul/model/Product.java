package com.johnathanmb.CartTul.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Modelo de producto de base de datos
 *
 * @author ja.monsalve.bello@gmail.com
 * @since JDK 1.8
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Product {
    private String id;
    private String name;
    private String sku;
    private String description;
}
